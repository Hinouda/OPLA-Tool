package br.otimizes.oplatool.patterns.models.ps.impl;

import br.otimizes.oplatool.architecture.representation.Element;
import br.otimizes.oplatool.patterns.designpatterns.DesignPattern;
import br.otimizes.oplatool.patterns.designpatterns.Strategy;
import br.otimizes.oplatool.patterns.models.AlgorithmFamily;
import br.otimizes.oplatool.patterns.models.ps.PS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Class PSStrategy.
 */
public class PSStrategy implements PS {

    private final List<Element> contexts;

    private final AlgorithmFamily algorithmFamily;

    public PSStrategy(List<Element> contexts, AlgorithmFamily algorithmFamily) {
        this.contexts = contexts;
        this.algorithmFamily = algorithmFamily;
    }

    @Override
    public DesignPattern getPSOf() {
        return Strategy.getInstance();
    }

    @Override
    public boolean isPSOf(DesignPattern designPattern) {
        return Strategy.getInstance().equals(designPattern);
    }

    @Override
    public List<Element> getParticipants() {
        List<Element> participants = new ArrayList<>(contexts);
        participants.addAll(algorithmFamily.getParticipants());
        return participants;
    }

    public List<Element> getContexts() {
        return contexts;
    }

    public AlgorithmFamily getAlgorithmFamily() {
        return algorithmFamily;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.algorithmFamily);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PSStrategy other = (PSStrategy) obj;
        return Objects.equals(this.algorithmFamily, other.algorithmFamily);
    }
}
