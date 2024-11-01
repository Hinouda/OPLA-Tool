package br.otimizes.oplatool.core.wizard;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class InteractionsResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clusteringAlgorithm;

    @Column(nullable = false)
    private String clusteringMoment;

    @Column(nullable = false)
    private int maxIterations;

    @Column(nullable = false)
    private int firstIteration;

    @Column(nullable = false)
    private int interval;

    @Column(nullable = false)
    private boolean interact;

    // Construtor sem argumentos necessário para JPA
    protected InteractionsResult() {
    }

    // Construtor com todos os argumentos
    public InteractionsResult(String clusteringAlgorithm, String clusteringMoment, int maxIterations,
                              int firstIteration, int interval, boolean interact) {
        this.clusteringAlgorithm = clusteringAlgorithm;
        this.clusteringMoment = clusteringMoment;
        this.maxIterations = maxIterations;
        this.firstIteration = firstIteration;
        this.interval = interval;
        this.interact = interact;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getClusteringAlgorithm() {
        return clusteringAlgorithm;
    }

    public void setClusteringAlgorithm(String clusteringAlgorithm) {
        this.clusteringAlgorithm = clusteringAlgorithm;
    }

    public String getClusteringMoment() {
        return clusteringMoment;
    }

    public void setClusteringMoment(String clusteringMoment) {
        this.clusteringMoment = clusteringMoment;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public int getFirstIteration() {
        return firstIteration;
    }

    public void setFirstIteration(int firstIteration) {
        this.firstIteration = firstIteration;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isInteract() {
        return interact;
    }

    public void setInteract(boolean interact) {
        this.interact = interact;
    }
}
