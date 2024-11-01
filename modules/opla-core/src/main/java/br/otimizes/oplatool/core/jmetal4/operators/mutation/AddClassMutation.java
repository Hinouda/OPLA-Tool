package br.otimizes.oplatool.core.jmetal4.operators.mutation;

import br.otimizes.oplatool.architecture.representation.*;
import br.otimizes.oplatool.architecture.representation.Class;
import br.otimizes.oplatool.architecture.representation.Package;
import br.otimizes.oplatool.core.jmetal4.core.Solution;
import br.otimizes.oplatool.common.Configuration;
import br.otimizes.oplatool.common.exceptions.JMException;
import br.otimizes.oplatool.core.jmetal4.operators.IOperator;
import br.otimizes.oplatool.core.jmetal4.problems.OPLA;
import br.otimizes.oplatool.core.jmetal4.util.PseudoRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * Mutation operator that add classes
 */
public class AddClassMutation implements IOperator<Solution> {

    @Override
    public Solution execute(Map<String, Object> parameters, Solution solution, String scope) {
        try {
            if (PseudoRandom.randDouble() < ((Double) parameters.get("probability"))) {
                if (solution.getDecisionVariables()[0].getVariableType() == java.lang.Class
                        .forName(Architecture.ARCHITECTURE_TYPE)) {
                    Architecture arch = ((Architecture) solution.getDecisionVariables()[0]);

                    Package sourceComp = MutationUtils.getRandomPackage(arch);
                    List<Class> classesPackage = new ArrayList<Class>(sourceComp.getAllClasses().stream().filter(c -> !c.isTotalyFreezed()).collect(Collectors.toList()));
                    MutationUtils.removeClassesInPatternStructureFromArray(classesPackage);
                    if (classesPackage.size() >= 1) {
                        Class sourceClassElem = MutationUtils.getRandomClass(classesPackage);

                        final Class sourceClass = sourceClassElem;
                        if ((sourceClass != null) && (!MutationUtils.searchForGeneralizations(sourceClass))
                                && (sourceClass.getAllAttributes().size() > 1)
                                && (sourceClass.getAllMethods().size() > 1) && (!MutationUtils.isVariationPoint(arch, sourceClass))
                                && (!MutationUtils.isVariant(arch, sourceClass)) && (!MutationUtils.isOptional(sourceClass))) {
                            if (MutationUtils.searchPatternsClass(sourceClass)) {
                                if (PseudoRandom.randInt(0, 1) == 0) { // attribute
                                    List<Attribute> AttributesClass = new ArrayList<Attribute>(
                                            sourceClass.getAllAttributes().stream().filter(c -> !c.isTotalyFreezed()).collect(Collectors.toList()));
                                    if (AttributesClass.size() >= 1) {
                                        if ("sameComponent".equals(scope)) {
                                            MutationUtils.moveAttributeToNewClass(arch, sourceClass, AttributesClass,
                                                    sourceComp.createClass("Class" + OPLA.countClass++, false));
                                        } else {
                                            if ("allComponents".equals(scope)) {
                                                Package targetComp = MutationUtils.getRandomPackage(arch);
                                                if (MutationUtils.checkSameLayer(sourceComp, targetComp)) {
                                                    MutationUtils.moveAttributeToNewClass(arch, sourceClass, AttributesClass,
                                                            targetComp.createClass("Class" + OPLA.countClass++, false));
                                                }
                                            }
                                        }
                                        AttributesClass.clear();
                                    }
                                }
                            } else {
                                if (MutationUtils.searchPatternsClass(sourceClass)) {
                                    List<Method> MethodsClass = new ArrayList<Method>(sourceClass.getAllMethods().stream().filter(c -> !c.isTotalyFreezed()).collect(Collectors.toList()));
                                    if (MethodsClass.size() >= 1) {
                                        if ("sameComponent".equals(scope)) {
                                            MutationUtils.moveMethodToNewClass(arch, sourceClass, MethodsClass,
                                                    sourceComp.createClass("Class" + OPLA.countClass++, false));
                                        } else {
                                            if ("allComponents".equals(scope)) {
                                                Package targetComp = MutationUtils.getRandomPackage(arch);
                                                if (MutationUtils.checkSameLayer(sourceComp, targetComp)) {
                                                    MutationUtils.moveMethodToNewClass(arch, sourceClass, MethodsClass,
                                                            targetComp.createClass("Class" + OPLA.countClass++, false));
                                                }
                                            }
                                        }
                                        MethodsClass.clear();
                                    }
                                }
                            }
                        }
                    }
                    classesPackage.clear();

                } else {
                    Configuration.logger_.log(Level.SEVERE, "AddClassMutation.doMutation: invalid type. " + "{0}",
                            solution.getDecisionVariables()[0].getVariableType());
                    java.lang.Class<String> cls = java.lang.String.class;
                    String name = cls.getName();
                    throw new JMException("Exception in " + name + ".doMutation()");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return solution;
    }

}
