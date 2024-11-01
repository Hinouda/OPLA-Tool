package br.otimizes.oplatool.core.wizard;

public class MutationOperatorResults {
    private float mutationRate;
    private boolean featureDrivenOperator;
    private boolean moveMethodMutation;
    private boolean moveAttributeMutation;
    private boolean moveOperationMutation;
    private boolean addClassMutation;
    private boolean addManagerClassMutation;
    private boolean featureDrivenOperatorForClass;

    // No-argument constructor
    public MutationOperatorResults() {
    }

    // Constructor with arguments
    public MutationOperatorResults(float mutationRate, boolean featureDrivenOperator,
                                   boolean moveMethodMutation, boolean moveAttributeMutation,
                                   boolean moveOperationMutation, boolean addClassMutation,
                                   boolean addManagerClassMutation, boolean featureDrivenOperatorForClass) {
        this.mutationRate = mutationRate;
        this.featureDrivenOperator = featureDrivenOperator;
        this.moveMethodMutation = moveMethodMutation;
        this.moveAttributeMutation = moveAttributeMutation;
        this.moveOperationMutation = moveOperationMutation;
        this.addClassMutation = addClassMutation;
        this.addManagerClassMutation = addManagerClassMutation;
        this.featureDrivenOperatorForClass = featureDrivenOperatorForClass;
    }

    // Getters and setters
    public float getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(float mutationRate) {
        this.mutationRate = mutationRate;
    }

    public boolean isFeatureDrivenOperator() {
        return featureDrivenOperator;
    }

    public void setFeatureDrivenOperator(boolean featureDrivenOperator) {
        this.featureDrivenOperator = featureDrivenOperator;
    }

    public boolean isMoveMethodMutation() {
        return moveMethodMutation;
    }

    public void setMoveMethodMutation(boolean moveMethodMutation) {
        this.moveMethodMutation = moveMethodMutation;
    }

    public boolean isMoveAttributeMutation() {
        return moveAttributeMutation;
    }

    public void setMoveAttributeMutation(boolean moveAttributeMutation) {
        this.moveAttributeMutation = moveAttributeMutation;
    }

    public boolean isMoveOperationMutation() {
        return moveOperationMutation;
    }

    public void setMoveOperationMutation(boolean moveOperationMutation) {
        this.moveOperationMutation = moveOperationMutation;
    }

    public boolean isAddClassMutation() {
        return addClassMutation;
    }

    public void setAddClassMutation(boolean addClassMutation) {
        this.addClassMutation = addClassMutation;
    }

    public boolean isAddManagerClassMutation() {
        return addManagerClassMutation;
    }

    public void setAddManagerClassMutation(boolean addManagerClassMutation) {
        this.addManagerClassMutation = addManagerClassMutation;
    }

    public boolean isFeatureDrivenOperatorForClass() {
        return featureDrivenOperatorForClass;
    }

    public void setFeatureDrivenOperatorForClass(boolean featureDrivenOperatorForClass) {
        this.featureDrivenOperatorForClass = featureDrivenOperatorForClass;
    }
}
