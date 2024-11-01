package br.otimizes.oplatool.core.wizard;



public class Interactions {
    public static InteractionsResult interactions(PLAInfo plaInfo) {
        int numClasses = plaInfo.getNumClasses(); 
        int numComponentes = plaInfo.getNumComponentes();
        int numInterfaces = plaInfo.getNumInterfaces();
        int numVariabilidades = plaInfo.getNumVariabilidades();

        String clusteringAlgorithm;
        String clusteringMoment;
        int maxInteractions;
        int firstInteraction;
        int interval;
        boolean interact = false; // Inicialmente, definir como false para nao forçar o usuario a precisar selecionar nada
        
        // Definir suas condições de árvore de decisão
        if (numVariabilidades < 10) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                clusteringAlgorithm = "KMEANS";
                clusteringMoment = "POSTERIORI";
                maxInteractions = 50;
                firstInteraction = 10;
                interval = 5;
                interact = true; 
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                clusteringAlgorithm = "DBSCAN";
                clusteringMoment = "BOTH";
                maxInteractions = 100;
                firstInteraction = 20;
                interval = 10;
                interact = true; // Manter como false para desmarcar a checkbox
            } else {
                clusteringAlgorithm = "DBSCAN";
                clusteringMoment = "BOTH";
                maxInteractions = 150;
                firstInteraction = 30;
                interval = 10;
                interact = true; 
            }
        } else if (numVariabilidades > 20) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                clusteringAlgorithm = "KMEANS";
                clusteringMoment = "ITERATIVE";
                maxInteractions = 70;
                firstInteraction = 15;
                interval = 7;
                interact = true; 
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                clusteringAlgorithm = "DBSCAN";
                clusteringMoment = "BOTH";
                maxInteractions = 200;
                firstInteraction = 40;
                interval = 20;
                interact = true; 
            } else {
                clusteringAlgorithm = "DBSCAN";
                clusteringMoment = "BOTH";
                maxInteractions = 300;
                firstInteraction = 60;
                interval = 20;
                interact = true; 
            }
        } else {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                clusteringAlgorithm = "DBSCAN";
                clusteringMoment = "BOTH";
                maxInteractions = 62;
                firstInteraction = 12;
                interval = 7;
                interact = true; 
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                clusteringAlgorithm = "DBSCAN";
                clusteringMoment = "BOTH";
                maxInteractions = 125;
                firstInteraction = 25;
                interval = 12;
                interact = true; 
            } else {
                clusteringAlgorithm = "DBSCAN";
                clusteringMoment = "BOTH";
                maxInteractions = 175;
                firstInteraction = 40;
                interval = 15;
                interact = true; 
            }
        }
        
        // Retornar os valores como um objeto InteractResult
        InteractionsResult result = new InteractionsResult(clusteringAlgorithm, clusteringMoment, maxInteractions, firstInteraction, interval, interact);
        
        // Exibir os resultados no terminal
        System.out.println("Interactions Result:");
        System.out.println("Clustering Algorithm: " + result.getClusteringAlgorithm());
        System.out.println("Clustering Moment: " + result.getClusteringMoment());
        System.out.println("Max Interactions: " + result.getMaxIterations());
        System.out.println("First Interaction: " + result.getFirstIteration());
        System.out.println("Interval: " + result.getInterval());
        System.out.println("Interact: " + result.isInteract());

        
        // Retornar o resultado
        return result;
    }
}
