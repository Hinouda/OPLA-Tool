package br.otimizes.oplatool.core.wizard;


public class Settings {
    public static SettingsResult settings(PLAInfo plaInfo) {
        int runs;
        int populationSize;
        int numberOfFitnessEvaluations;

        int numClasses = plaInfo.getNumClasses();
        int numComponentes = plaInfo.getNumComponentes();
        int numInterfaces = plaInfo.getNumInterfaces();
        int numVariabilidades = plaInfo.getNumVariabilidades();
 

        if (numVariabilidades < 10) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                runs = 15;
                populationSize = 200;
                numberOfFitnessEvaluations = 3000;
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                runs = 300;
                populationSize = 100;
                numberOfFitnessEvaluations = 30000;
            } else {
                runs = 300;
                populationSize = 100;
                numberOfFitnessEvaluations = 30000;
            }
        } else if (numVariabilidades > 20) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                runs = 25;
                populationSize = 300;
                numberOfFitnessEvaluations = 5000;
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                runs = 300;
                populationSize = 100;
                numberOfFitnessEvaluations = 30000;
            } else {
                runs = 300;
                populationSize = 100;
                numberOfFitnessEvaluations = 30000;
            }
        } else {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                runs = 35;
                populationSize = 500;
                numberOfFitnessEvaluations = 9000;
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                runs = 300;
                populationSize = 100;
                numberOfFitnessEvaluations = 30000;
            } else {
                runs = 300;
                populationSize = 100;
                numberOfFitnessEvaluations = 30000;
            }
        }

        return new SettingsResult(runs, populationSize, numberOfFitnessEvaluations);
    }
}
