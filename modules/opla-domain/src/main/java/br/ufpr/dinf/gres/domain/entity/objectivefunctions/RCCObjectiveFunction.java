package br.ufpr.dinf.gres.domain.entity.objectivefunctions;

import br.ufpr.dinf.gres.domain.entity.Execution;
import br.ufpr.dinf.gres.domain.entity.Experiment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cbcs_obj")
public class RCCObjectiveFunction extends ObjectiveFunctionDomain {

    private static final long serialVersionUID = 1L;

    @Column(name = "cbcs")
    private Double cbcs;

    public RCCObjectiveFunction(String idSolution, Execution execution, Experiment experiement) {
        super(idSolution, execution, experiement);
    }

    public Double getCbcs() {
        return cbcs;
    }

    public void setCbcs(Double cbcs) {
        this.cbcs = cbcs;
    }


}
