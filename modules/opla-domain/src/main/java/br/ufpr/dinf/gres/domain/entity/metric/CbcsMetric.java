package br.ufpr.dinf.gres.domain.entity.metric;

import br.ufpr.dinf.gres.domain.entity.Execution;
import br.ufpr.dinf.gres.domain.entity.Experiment;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cbcs_metrics")
public class CbcsMetric implements GenericMetric {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cbcs")
    private String cbcs;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "execution_id")
    private Execution execution;

    @ManyToOne
    @JoinColumn(name = "experiement_id", nullable = false)
    private Experiment experiment;

    @Column(name = "is_all")
    private Integer isAll;

    @Column(name = "id_solution")
    private String idSolution;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Execution getExecution() {
        return execution;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Integer getIsAll() {
        return isAll;
    }

    public void setIsAll(Integer isAll) {
        this.isAll = isAll;
    }

    public String getIdSolution() {
        return idSolution;
    }

    public void setIdSolution(String idSolution) {
        this.idSolution = idSolution;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCbcs() {
        return cbcs;
    }

    public void setCbcs(String cbcs) {
        this.cbcs = cbcs;
    }

    public void setExecution(Execution execution) {
        this.execution = execution;
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
        CbcsMetric castOther = (CbcsMetric) other;
        return Objects.equals(id, castOther.id) && Objects.equals(execution, castOther.execution)
                && Objects.equals(cbcs, castOther.cbcs)
                && Objects.equals(experiment, castOther.experiment) && Objects.equals(isAll, castOther.isAll)
                && Objects.equals(idSolution, castOther.idSolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cbcs, execution, experiment, isAll, idSolution);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id)
                .append("cbcs", cbcs).append("executionId", execution)
                .append("experiementId", experiment).append("isAll", isAll).append("idSolution", idSolution)
                .toString();
    }

}
