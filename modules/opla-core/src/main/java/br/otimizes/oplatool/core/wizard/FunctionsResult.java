package br.otimizes.oplatool.core.wizard;

import java.util.List;
public class FunctionsResult {
    // Campos booleanos para armazenar os resultados das funções objetivas
    private boolean ACLASS;
    private boolean COE;
    private boolean ELEG;
    private boolean SD;
    private boolean CS;
    private boolean ACOMP;
    private boolean CM;
    private boolean FM;
    private boolean SV;
    private boolean LFCC;
    private boolean TV;
    private boolean DC;
    private boolean LCC;
    private boolean TAM;
    private boolean FDAC;
    private boolean RCC;
    private boolean EC;
    private boolean EXT;
    private boolean WOCSCLASS;
    private boolean CIBF;
    private List<String> messages;


    // Construtor com argumentos
    public FunctionsResult(boolean ACLASS, boolean COE, boolean ELEG, boolean SD, boolean CS,
                           boolean ACOMP, boolean CM, boolean FM, boolean SV, boolean LFCC,
                           boolean TV, boolean DC, boolean LCC, boolean TAM, boolean FDAC,
                           boolean RCC, boolean EC, boolean EXT, boolean WOCSCLASS, boolean CIBF, List<String> messages) {
        this.ACLASS = ACLASS;
        this.COE = COE;
        this.ELEG = ELEG;
        this.SD = SD;
        this.CS = CS;
        this.ACOMP = ACOMP;
        this.CM = CM;
        this.FM = FM;
        this.SV = SV;
        this.LFCC = LFCC;
        this.TV = TV;
        this.DC = DC;
        this.LCC = LCC;
        this.TAM = TAM;
        this.FDAC = FDAC;
        this.RCC = RCC;
        this.EC = EC;
        this.EXT = EXT;
        this.WOCSCLASS = WOCSCLASS;
        this.CIBF = CIBF;
        this.messages = messages;
 
        
    }

    // Os métodos restantes podem permanecer inalterados...
    public void addMessage(String message) {
        messages.add(message);
    }

    // Método para obter as mensagens
    public List<String> getMessages() {
        return messages;
    }


    // Getters para acessar os valores dos campos
    public boolean isACLASS() {
        return ACLASS;
    }

    public boolean isCOE() {
        return COE;
    }

    public boolean isELEG() {
        return ELEG;
    }

    public boolean isSD() {
        return SD;
    }

    public boolean isCS() {
        return CS;
    }

    public boolean isACOMP() {
        return ACOMP;
    }

    public boolean isCM() {
        return CM;
    }

    public boolean isFM() {
        return FM;
    }

    public boolean isSV() {
        return SV;
    }

    public boolean isLFCC() {
        return LFCC;
    }

    public boolean isTV() {
        return TV;
    }

    public boolean isDC() {
        return DC;
    }

    public boolean isLCC() {
        return LCC;
    }

    public boolean isTAM() {
        return TAM;
    }

    public boolean isFDAC() {
        return FDAC;
    }

    public boolean isRCC() {
        return RCC;
    }

    public boolean isEC() {
        return EC;
    }

    public boolean isEXT() {
        return EXT;
    }

    public boolean isWOCSCLASS() {
        return WOCSCLASS;
    }

    public boolean isCIBF() {
        return CIBF;
    }

    
}
