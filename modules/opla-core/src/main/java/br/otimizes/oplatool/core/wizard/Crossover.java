package br.otimizes.oplatool.core.wizard;


public class Crossover {
    public static CrossoverResult crossover(PLAInfo plaInfo) {
        double crossoverRate;
        boolean plaFeatureDrivenCrossover;
        boolean plaComplementaryCrossover;
        boolean plaModularCrossover;
        int numClasses = plaInfo.getNumClasses(); 
        int numComponentes = plaInfo.getNumComponentes();
        int numInterfaces = plaInfo.getNumInterfaces();
        int numVariabilidades = plaInfo.getNumVariabilidades();


        if (numVariabilidades < 10) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = true;
                plaComplementaryCrossover = false;
                plaModularCrossover = true;
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = false;
                plaComplementaryCrossover = true;
                plaModularCrossover = true;
            } else {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = false;
                plaComplementaryCrossover = true;
                plaModularCrossover = true;
            }
        } else if (numVariabilidades > 20) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = true;
                plaComplementaryCrossover = false;
                plaModularCrossover = true;
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = true;
                plaComplementaryCrossover = false;
                plaModularCrossover = true;
            } else {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = true;
                plaComplementaryCrossover = false;
                plaModularCrossover = true;
            }
        } else {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = true;
                plaComplementaryCrossover = false;
                plaModularCrossover = true;
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = false;
                plaComplementaryCrossover = true;
                plaModularCrossover = true;
            } else {
                crossoverRate = 0.4;
                plaFeatureDrivenCrossover = true;
                plaComplementaryCrossover = false;
                plaModularCrossover = true;
            }
        }

        // Retornar um objeto CrossoverResult com as configurações determinadas
        CrossoverResult result = new CrossoverResult(crossoverRate, plaFeatureDrivenCrossover, plaComplementaryCrossover, plaModularCrossover);

        // Mostrar o resultado no terminal
        System.out.println("Crossover Result:");
        System.out.println("Crossover Rate: " + result.getCrossoverRate());
        System.out.println("PLA Feature-Driven Crossover: " + result.isFeatureDrivenCrossover());
        System.out.println("PLA Complementary Crossover: " + result.isComplementaryCrossover());
        System.out.println("PLA Modular Crossover: " + result.isModularCrossover());

        // Retornar o resultado
        return result;
    }
}
