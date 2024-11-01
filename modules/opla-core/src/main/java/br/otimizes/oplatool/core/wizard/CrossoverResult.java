package br.otimizes.oplatool.core.wizard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class CrossoverResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double crossoverRate;

    @Column(nullable = false)
    private boolean plaFeatureDrivenCrossover;

    @Column(nullable = false)
    private boolean plaComplementaryCrossover;

    @Column(nullable = false)
    private boolean plaModularCrossover;

    // Construtor sem argumentos necessário para JPA
    protected CrossoverResult() {
    }

    // Construtor com todos os argumentos
    public CrossoverResult(double crossoverRate, boolean plaFeatureDrivenCrossover,
                           boolean plaComplementaryCrossover, boolean plaModularCrossover) {
        this.crossoverRate = crossoverRate;
        this.plaFeatureDrivenCrossover = plaFeatureDrivenCrossover;
        this.plaComplementaryCrossover = plaComplementaryCrossover;
        this.plaModularCrossover = plaModularCrossover;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public boolean isFeatureDrivenCrossover() {
        return plaFeatureDrivenCrossover;
    }

    public boolean isComplementaryCrossover() {
        return plaComplementaryCrossover;
    }

    public boolean isModularCrossover() {
        return plaModularCrossover;
    }

    // Setters, se necessário
    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }
}
