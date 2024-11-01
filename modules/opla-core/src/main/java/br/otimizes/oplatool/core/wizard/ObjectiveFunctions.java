
package br.otimizes.oplatool.core.wizard;

import java.util.ArrayList;
import java.util.List;


public class ObjectiveFunctions {

    public static FunctionsResult calculateFunctionsResult(PLAInfo plaInfo) {
        int numClasses = plaInfo.getNumClasses(); 
        int numComponentes = plaInfo.getNumComponentes();
        int numInterfaces = plaInfo.getNumInterfaces();
        int estereotiposUnicos = plaInfo.getNumUniqueStereotypes();
        int metodosUnicos = plaInfo.getNumUniqueMethods();
        boolean ACLASS = false;
        boolean COE = false;
        boolean ELEG = false;
        boolean SD = false;
        boolean CS = false;
        boolean ACOMP = false;
        boolean CM = false;
        boolean FM = false;
        boolean SV = false;
        boolean LFCC = false;
        boolean TV = false;
        boolean DC = false;
        boolean LCC = false;
        boolean TAM = false;
        boolean FDAC = false;
        boolean RCC = false;
        boolean EC = false;
        boolean EXT = false;
        boolean WOCSCLASS = false;
        boolean CIBF = false;
        
        // Crie uma lista para armazenar mensagens
        List<String> messages = new ArrayList<>();
        
        double interfaceToComponentRatio = (double) numInterfaces / numComponentes;

        // Condições para as funções objetivas
        if (estereotiposUnicos < 13) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                messages.add("Optimize structural variability and total variability in a low complexity environment.");
                SV = true;
                TV= true;
                ACOMP= true;
                RCC= true;
                SD= true;
                SV= true;
                ACLASS = true;
                CS= true;
                if (estereotiposUnicos < 3 && metodosUnicos > 20) {
                    messages.add("Focus on feature diffusion and modularity due to unique stereotype and method count.");
                    DC = true;
                    FM = true;
                }
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                messages.add("Manage component size, feature interaction, and component coupling in a highly complex environment.");
                CS = true;
                EC = true;
                ACOMP = true;
                if (metodosUnicos > 50) {
                    messages.add("Address class coupling due to high method uniqueness.");
                    ACLASS = true;
                }
            } else {
                messages.add("Address feature diffusion and interaction complexity in a moderately complex architecture.");
                DC = true;
                EC = true;
                if (interfaceToComponentRatio < 0.5) {
                    messages.add("Prioritize PLA design cohesion and component coupling.");
                    COE = true;
                    ACOMP = true;
                }
            }
        } else if (estereotiposUnicos > 21) {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                messages.add("Manage high variability impact on interactions without added complexity.");
                EC = true;
                SV = true;
                TV = true;
                
                if (interfaceToComponentRatio < 0.5) {
                    messages.add("Prioritize design cohesion and component coupling in high variability scenarios.");
                    COE = true;
                    ACOMP = true;
                }
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                messages.add("Address component coupling, component size, and variability measures in highly complex and variable environments.");
                ACOMP = true;
                CS = true;
                SV = true;
                TV = true;
                if (interfaceToComponentRatio > 2) {
                    messages.add("Focus on relational coupling and feature modularity.");
                    RCC = true;
                    FM = true;
                }
            } else {
                messages.add("Feature Diffusion (DC), Feature Interaction (EC), and Variability Measures (CV, SV, TV) to address both the complexity and high variability challenges.");
                DC = true;
                EC = true;
                SV = true;
                TV = true;
                if (metodosUnicos > 50) {
                    messages.add("Prioritize class coupling due to high method uniqueness.");
                    ACLASS = true;
                }
            }
        } else {
            if (numComponentes <= 50 && numClasses <= 100 && numInterfaces <= 25) {
                messages.add("Optimize relational coupling, cohesion, and class coupling in a low complexity setting.");
                TAM = true;
                CS = true;
                LCC= true;
                EC= true;
                

                if (metodosUnicos < 30 && estereotiposUnicos > 5) {
                    messages.add("Prioritize class coupling and component size due to unique stereotype count and low method uniqueness.");
                    ACLASS = true;
                    TAM = true;
                }
            } else if (numComponentes > 100 && numClasses > 150 && numInterfaces > 40) {
                messages.add("Control feature spread and interactions with optimal cohesion for medium complexity and variability.");
                DC = true;
                EC = true;
                COE = true;
                
            } else {
                messages.add("Optimize class and relational coupling, along with variability and component size in complex scenarios.");
                ACLASS= true;
                RCC= true;
                ACOMP= true;
                RCC= true;
                SD= true;
                SV= true;
                TAM = true;
                CS= true;
                if (interfaceToComponentRatio > 2) {
                    messages.add("Focus on feature modularity due to high interface to component ratio.");
                    
                    FM = true;
                }
            }
        }

        // Retorne um novo objeto FunctionsResult com os valores booleanos e as mensagens acumuladas
        FunctionsResult result = new FunctionsResult(ACLASS, COE, ELEG, SD, CS, ACOMP, CM, FM, SV, LFCC, TV, DC, LCC, TAM, FDAC, RCC, EC, EXT, WOCSCLASS, CIBF, messages);

        
        
        return result;
    }
}
