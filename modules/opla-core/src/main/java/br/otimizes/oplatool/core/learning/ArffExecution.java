package br.otimizes.oplatool.core.learning;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Attribute-Relation File Format Object used in Machine Learnings presents in Weka
 */
public class ArffExecution {

    private ArrayList<Attribute> atts = new ArrayList<>();
    private ArrayList<Attribute> attVals = new ArrayList<>();
    private Instances data;
    private double[] vals;
    private int attrIndices;
    private double[][] attributes;
    private boolean binary = false;

    /**
     * To use it, instantiate the class by passing a list of function values Objective
     *
     * @param attributes Function Values Objective
     */
    public ArffExecution(double[][] attributes) {
        newInstance(attributes, null, null);
    }

    /**
     * To use it, instantiate the class by passing a list of function values Objective and descriptions for the same
     *
     * @param attributes    Function Values Objective
     * @param descOjectives Objectives Description
     */
    public ArffExecution(double[][] attributes, double[] classes, String[] descOjectives) {
        newInstance(attributes, classes, descOjectives);
    }

    /**
     * To use it, instantiate the class by passing a list of function values Objective and descriptions for the same
     *
     * @param attributes    Function Values Objective
     * @param descOjectives Objectives Description
     */
    public ArffExecution(double[][] attributes, double[] classes, String[] descOjectives, boolean binary) {
        this.binary = binary;
        newInstance(attributes, classes, descOjectives);
    }

    private void newInstance(double[][] attributes, double[] classes, String[] descAttributes) {
        if (attributes.length <= 0) return;
        attrIndices = attributes[0].length;
        this.attributes = attributes;
        // - numeric
        if (descAttributes != null) {
            for (String descOjective : descAttributes) {
                atts.add(new Attribute(descOjective));
            }
        } else {
            for (int j = 0; j < attributes[0].length; j++) {
                atts.add(new Attribute("obj" + (j + 1)));
            }
        }
        // - string
        if (binary) {
            atts.add(new Attribute("class", Arrays.asList("0", "1")));
        } else {
            atts.add(new Attribute("class", Arrays.asList("0", "1", "2", "3", "4", "5")));
        }
        data = new Instances("MyRelation", atts, 0);

        for (int i = 0; i < attributes.length; i++) {
            vals = new double[data.numAttributes()];
            for (int j = 0; j < attributes[0].length; j++) {
                vals[j] = attributes[i][j];
            }
            if (classes != null)
                vals[attributes[0].length] = classes[i];
            else
                vals[attributes[0].length] = 0;
            data.add(new DenseInstance(1.0, vals));
        }

        Normalize normalize = new Normalize();
        try {
            normalize.setInputFormat(getData());
            setData(Filter.useFilter(getData(), normalize));
            getData().randomize(new Random(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("add");
    }

    public ArrayList<Attribute> getAtts() {
        return atts;
    }

    public void setAtts(ArrayList<Attribute> atts) {
        this.atts = atts;
    }

    public ArrayList<Attribute> getAttVals() {
        return attVals;
    }

    public void setAttVals(ArrayList<Attribute> attVals) {
        this.attVals = attVals;
    }

    public Instances getData() {
        return data;
    }

    public void setData(Instances data) {
        this.data = data;
    }

    public double[] getVals() {
        return vals;
    }

    public void setVals(double[] vals) {
        this.vals = vals;
    }


    @Override
    public String toString() {
        return "ArffExecution{" +
                "atts=" + atts +
                ", attVals=" + attVals +
                ", data=" + data +
                ", vals=" + Arrays.toString(vals) +
                '}';
    }

    public int getAttrIndices() {
        return attrIndices;
    }

    public void setAttrIndices(int attrIndices) {
        this.attrIndices = attrIndices;
    }

    public double[][] getAttributes() {
        return attributes;
    }

    public void setAttributes(double[][] attributes) {
        this.attributes = attributes;
    }

    /**
     * Used to get Instances withod last column that indentify the class of object
     *
     * @return Instances without class
     */
    public Instances getDataWithoutClass() {
        Instances newIn = new Instances(this.getData());
        newIn.setClassIndex(-1);
        newIn.deleteAttributeAt(attrIndices);
        return newIn;
    }
}
