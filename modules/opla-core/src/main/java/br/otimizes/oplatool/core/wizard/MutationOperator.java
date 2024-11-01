
package br.otimizes.oplatool.core.wizard;


public class MutationOperator {
    public static MutationOperatorResults mutationOperator(PLAInfo plaInfo) {
        int numClasses = plaInfo.getNumClasses(); 
        int numComponentes = plaInfo.getNumComponentes();
        int numInterfaces = plaInfo.getNumInterfaces();
        int numVariabilidades = plaInfo.getNumVariabilidades();
        float mutationRate = 0.0f;
        boolean featureDrivenOperator = true;
        boolean moveMethodMutation = true;
        boolean moveAttributeMutation = true;
        boolean moveOperationMutation = true;
        boolean addClassMutation = true;
        boolean addManagerClassMutation = true;
        boolean featureDrivenOperatorForClass = true;

        if (numVariabilidades < 10) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                mutationRate = 0.8f;
                
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                mutationRate = 0.9f;               
                
            } else {
                mutationRate = 0.9f;
                
            }
        } else if (numVariabilidades > 20) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                mutationRate = 0.8f;
                
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                mutationRate = 0.9f;
                
            } else {
                mutationRate = 0.9f;
                
            }
        } else {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                mutationRate = 0.8f;
                
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                mutationRate = 0.9f;
                
            } else {
                mutationRate = 0.9f;
                
            }
        }

        MutationOperatorResults results = new MutationOperatorResults(mutationRate, featureDrivenOperator, moveMethodMutation,
                                                                     moveAttributeMutation, moveOperationMutation, addClassMutation,
                                                                     addManagerClassMutation, featureDrivenOperatorForClass);
        
        // Exibir os resultados no terminal
        System.out.println("Mutation Operator Results:");
        System.out.println("Mutation Rate: " + results.getMutationRate());
        System.out.println("Feature Driven Operator: " + results.isFeatureDrivenOperator());
        System.out.println("Move Method Mutation: " + results.isMoveMethodMutation());
        System.out.println("Move Attribute Mutation: " + results.isMoveAttributeMutation());
        System.out.println("Move Operation Mutation: " + results.isMoveOperationMutation());
        System.out.println("Add Class Mutation: " + results.isAddClassMutation());
        System.out.println("Add Manager Class Mutation: " + results.isAddManagerClassMutation());
        System.out.println("Feature Driven Operator for Class: " + results.isFeatureDrivenOperatorForClass());

        // Retornar o resultado
        return results;
    }
}
