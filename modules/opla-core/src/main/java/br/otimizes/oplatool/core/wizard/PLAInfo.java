package br.otimizes.oplatool.core.wizard;

public class PLAInfo {
    private int numClasses;
    private int numComponentes;
    private int numInterfaces;
    private int numVariabilidades;
    private int numUniqueMethods;
    private int numUniqueStereotypes;

    public PLAInfo(int numClasses, int numComponentes, int numInterfaces, int numVariabilidades, int numUniqueMethods, int numUniqueStereotypes) {
        this.numClasses = numClasses;
        this.numComponentes = numComponentes;
        this.numInterfaces = numInterfaces;
        this.numVariabilidades = numVariabilidades;
        this.numUniqueMethods = numUniqueMethods;
        this.numUniqueStereotypes = numUniqueStereotypes;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public int getNumComponentes() {
        return numComponentes;
    }

    public int getNumInterfaces() {
        return numInterfaces;
    }

    public int getNumVariabilidades() {
        return numVariabilidades;
    }

    public int getNumUniqueMethods() {
        return numUniqueMethods;
    }

    public int getNumUniqueStereotypes() {
        return numUniqueStereotypes;
    }
}
