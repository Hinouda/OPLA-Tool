package br.ufpr.dinf.gres.core.jmetal4.metrics.objectivefunctions;

import br.ufpr.dinf.gres.architecture.representation.Architecture;
import br.ufpr.dinf.gres.core.jmetal4.metrics.ObjectiveFunctionBase;
import br.ufpr.dinf.gres.core.jmetal4.metrics.conventionalMetrics.RelationalCohesion;

/**
 * Cohesion (Santos et al., 2015)
 * <p>
 * It aims to measure the relational cohesion between classes.
 * (H - Relational Cohesion)
 */
public class COE extends ObjectiveFunctionBase {

    public COE(Architecture architecture) {
        super(architecture);
        RelationalCohesion rc = new RelationalCohesion(architecture);
        this.setResults(rc.getResults());
    }

}
