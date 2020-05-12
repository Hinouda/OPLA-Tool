package br.ufpr.dinf.gres.core.jmetal4.metrics.concernDrivenMetrics.concernDiffusion;

import br.ufpr.dinf.gres.architecture.representation.Architecture;
import br.ufpr.dinf.gres.architecture.representation.Concern;

import java.util.ArrayList;

/**
 * Abstract concern diffusion metric
 * @param <T> type of element
 */
public abstract class ConcernDiffusionMetric<T> {
    private final Architecture architecture;
    private final ArrayList<T> results = new ArrayList<T>();

    public ConcernDiffusionMetric(Architecture architecture) {
        this.architecture = architecture;

        for (Concern concern : architecture.getAllConcerns()) {
            getResults().add(getElementForConcern(concern));
        }
    }

    public Architecture getArchitecture() {
        return architecture;
    }

    public ArrayList<T> getResults() {
        return results;
    }

    protected abstract T getElementForConcern(Concern concern);
}
