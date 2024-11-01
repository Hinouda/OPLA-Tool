package br.otimizes.oplatool.patterns.util;

import br.otimizes.oplatool.architecture.representation.*;
import br.otimizes.oplatool.architecture.representation.relationship.Relationship;
import br.otimizes.oplatool.patterns.comparators.SubElementsComparator;
import br.otimizes.oplatool.patterns.list.MethodArrayList;
import br.otimizes.oplatool.patterns.models.AlgorithmFamily;
import br.otimizes.oplatool.patterns.repositories.ArchitectureRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class StrategyUtil.
 */
public class StrategyUtil {

    private StrategyUtil() {
    }

    public static Interface getStrategyInterfaceFromAlgorithmFamily(AlgorithmFamily algorithmFamily) {
        List<Element> participants = algorithmFamily.getParticipants();
        List<Interface> interfaces = getAllStrategyInterfacesFromSetOfElements(participants);
        if (!interfaces.isEmpty()) {
            interfaces.sort(SubElementsComparator.getDescendingOrderer());
            return interfaces.get(0);
        } else {
            Architecture architecture = ArchitectureRepository.getCurrentArchitecture();
            return architecture.findInterfaceByName(algorithmFamily.getNameCapitalized() + "Strategy");
        }
    }

    protected static List<Interface> getAllStrategyInterfacesFromSetOfElements(List<Element> elements) {
        List<Interface> strategyInterfaces = new ArrayList<>();
        List<Interface> interfaces = ElementUtil.getAllSuperInterfaces(elements);
        MethodArrayList allMethodsFromAlgorithmFamily = new MethodArrayList(MethodUtil.getAllCommonMethodsFromSetOfElements(elements));
        if (allMethodsFromAlgorithmFamily.isEmpty()) {
            allMethodsFromAlgorithmFamily = new MethodArrayList(MethodUtil.getAllMethodsFromSetOfElements(elements));
        }
        for (Interface anInterface : interfaces) {
            MethodArrayList interfaceMethods = new MethodArrayList(MethodUtil.getAllMethodsFromElement(anInterface));
            if (interfaceMethods.containsAll(allMethodsFromAlgorithmFamily)) {
                strategyInterfaces.add(anInterface);
            }
        }
        return strategyInterfaces;
    }

    public static Interface createStrategyInterfaceForAlgorithmFamily(AlgorithmFamily algorithmFamily) {
        return InterfaceUtil.createInterfaceForSetOfElements(algorithmFamily.getNameCapitalized() + "Strategy", algorithmFamily.getParticipants());
    }

    public static boolean areTheAlgorithmFamilyAndContextsPartOfAVariability(AlgorithmFamily algorithmFamily, List<Element> contexts) {
        List<Variability> variabilities = null;
        for (Element algorithm : algorithmFamily.getParticipants()) {
            if (algorithm.getVariant() == null) {
                return false;
            }
            if (variabilities == null) {
                variabilities = new ArrayList<>(algorithm.getVariant().getVariabilities());
            } else if (!variabilities.isEmpty()) {
                for (int i = 0; i < variabilities.size(); i++) {
                    if (!algorithm.getVariant().getVariabilities().contains(variabilities.get(i))) {
                        variabilities.remove(i);
                        i--;
                    }
                }
            } else {
                return false;
            }
        }
        if (variabilities == null || variabilities.isEmpty()) {
            return false;
        }
        return doesContextHasVariability(contexts, variabilities);
    }

    private static boolean doesContextHasVariability(List<Element> contexts, List<Variability> variabilities) {
        for (Element context : contexts) {
            if (context.getVariationPoint() != null) {
                List<Variability> contextVariabilities = context.getVariationPoint().getVariabilities();
                for (Variability variability : contextVariabilities) {
                    if (variabilities.contains(variability)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void moveContextsRelationshipWithSameTypeAndName(List<Element> contexts, List<Element> participants, Element target) {
        Architecture architecture = ArchitectureRepository.getCurrentArchitecture();
        for (Element context : contexts) {
            HashMap<String, HashMap<String, List<Relationship>>> usingRelationshipsFromAlgorithms = new HashMap<>();
            for (Relationship relationShip : ElementUtil.getRelationships(context)) {
                Element usedElementFromRelationship = RelationshipUtil.getUsedElementFromRelationship(relationShip);
                if (usedElementFromRelationship != null
                        && !usedElementFromRelationship.equals(context)
                        && (participants.contains(usedElementFromRelationship)
                        || target.equals(usedElementFromRelationship))) {
                    HashMap<String, List<Relationship>> relationshipByType = usingRelationshipsFromAlgorithms.computeIfAbsent(relationShip.getType(), k -> new HashMap<>());
                    List<Relationship> relationshipByName = relationshipByType.computeIfAbsent(relationShip.getName(), k -> new ArrayList<>());
                    relationshipByName.add(relationShip);
                }
            }
            for (Map.Entry<String, HashMap<String, List<Relationship>>> byTypeEntry : usingRelationshipsFromAlgorithms.entrySet()) {
                HashMap<String, List<Relationship>> typeMap = byTypeEntry.getValue();
                for (Map.Entry<String, List<Relationship>> nameEntry : typeMap.entrySet()) {
                    List<Relationship> nameList = nameEntry.getValue();
                    Relationship relationship = nameList.get(0);
                    for (Relationship tempRelationship : nameList) {
                        architecture.removeRelationship(tempRelationship);
                    }
                    ArchitectureRepository.getCurrentArchitecture().addRelationship(relationship);
                    RelationshipUtil.moveRelationship(relationship, context, target);
                }
            }
        }
    }

    public static void moveVariabilitiesFromContextsToTarget(List<Element> contexts, List<Element> participants, Element target) {
        for (Element context : contexts) {
            VariationPoint variationPoint = context.getVariationPoint();
            if (variationPoint != null) {
                List<Variant> participantsVariants = new ArrayList<>();
                for (Element participant : participants) {
                    if (participant.getVariant() != null) {
                        participantsVariants.add(participant.getVariant());
                    }
                }
                if (participantsVariants.containsAll(variationPoint.getVariants())) {
                    context.setVariationPoint(null);
                    target.setVariationPoint(variationPoint);
                    variationPoint.replaceVariationPointElement(target);
                    for (Variant variant : participantsVariants) {
                        variant.setRootVP(variationPoint.getVariationPointElement().getName());
                    }
                }
            }
        }
    }
}
