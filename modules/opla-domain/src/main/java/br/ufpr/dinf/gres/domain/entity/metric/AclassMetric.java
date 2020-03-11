package br.ufpr.dinf.gres.domain.entity.metric;

import br.ufpr.dinf.gres.domain.entity.Execution;
import br.ufpr.dinf.gres.domain.entity.Experiment;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "aclass_metrics")
public class AclassMetric extends BaseMetric {

    private static final long serialVersionUID = 1L;

    @Column(name = "sumclassdepin")
    private Double sumClassesDepIn;
    @Column(name = "sumclassdepout")
    private Double sumClassesDepOut;

    public AclassMetric(String idSolution, Execution execution, Experiment experiement) {
        super(idSolution, execution, experiement);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Double getSumClassesDepIn() {
        return sumClassesDepIn;
    }

    public void setSumClassesDepIn(Double sumClassesDepIn) {
        this.sumClassesDepIn = sumClassesDepIn;
    }

    public Double getSumClassesDepOut() {
        return sumClassesDepOut;
    }

    public void setSumClassesDepOut(Double sumClassesDepOut) {
        this.sumClassesDepOut = sumClassesDepOut;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!getClass().equals(other.getClass())) {
            return false;
        }
        AclassMetric castOther = (AclassMetric) other;
        return Objects.equals(getId(), castOther.getId()) && Objects.equals(getExecution(), castOther.getExecution())
                && Objects.equals(getExperiment(), castOther.getExperiment()) && Objects.equals(getIsAll(), castOther.getIsAll())
                && Objects.equals(getIdSolution(), castOther.getIdSolution())
                && Objects.equals(sumClassesDepIn, castOther.sumClassesDepIn)
                && Objects.equals(sumClassesDepOut, castOther.sumClassesDepOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getExecution(), getExperiment(), getIsAll(), getIdSolution(), sumClassesDepIn, sumClassesDepOut);
    }


}
