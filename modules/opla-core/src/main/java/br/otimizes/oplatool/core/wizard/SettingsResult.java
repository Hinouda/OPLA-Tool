package br.otimizes.oplatool.core.wizard;


public class SettingsResult {
    private int runs;
    private int populationSize;
    private int numberOfFitnessEvaluations;

    public SettingsResult() {}

    public SettingsResult(int runs, int populationSize, int numberOfFitnessEvaluations) {
        this.runs = runs;
        this.populationSize = populationSize;
        this.numberOfFitnessEvaluations = numberOfFitnessEvaluations;
    }

    // Getters e setters
    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getNumberOfFitnessEvaluations() {
        return numberOfFitnessEvaluations;
    }

    public void setNumberOfFitnessEvaluations(int numberOfFitnessEvaluations) {
        this.numberOfFitnessEvaluations = numberOfFitnessEvaluations;
    }
}
