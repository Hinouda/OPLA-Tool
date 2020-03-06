package br.ufpr.dinf.gres.core.jmetal4.experiments;

import br.ufpr.dinf.gres.common.exceptions.MissingConfigurationException;
import br.ufpr.dinf.gres.core.jmetal4.core.Solution;
import br.ufpr.dinf.gres.core.jmetal4.core.SolutionSet;
import br.ufpr.dinf.gres.core.jmetal4.qualityIndicator.util.MetricsUtil;
import br.ufpr.dinf.gres.core.jmetal4.util.NonDominatedSolutionList;
import br.ufpr.dinf.gres.core.persistence.Persistence;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.HashMap;

@Service
public class CalculaEd {

    private MetricsUtil mu;
    private NumberFormat format = NumberFormat.getInstance();

    private final Persistence persistence;

    public CalculaEd(Persistence persistence) {
        mu = new MetricsUtil();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        format.setMaximumIntegerDigits(2);
        format.setRoundingMode(RoundingMode.HALF_UP);
        this.persistence = persistence;
    }

    private static double arredondar(double valor, int casas, int ceilOrFloor) {
        double arredondado = valor;
        arredondado *= (Math.pow(10, casas));
        if (ceilOrFloor == 0) {
            arredondado = Math.ceil(arredondado);
        } else {
            arredondado = Math.floor(arredondado);
        }
        arredondado /= (Math.pow(10, casas));
        return arredondado;
    }

    /**
     * Calcule distance euclideans given a experiment id.
     *
     * @param experimentId
     * @param numberObjectives
     * @return {@link HashMap<String, Double>}. Solution Name, Distance Euclidean
     * @throws Exception
     */
    public HashMap<String, Double> calcula(String experimentId, int numberObjectives) throws Exception {
        SolutionSet ss = persistence.queryNonDominatedSolutinsFromExperiment(experimentId);
        HashMap<String, Double> results = new HashMap<>();

        String[] names = new String[ss.size()];
        for (int i = 0; i < ss.size(); i++)
            names[i] = ss.get(i).getSolutionName();

        double[][] front = ss.writeObjectivesToMatrix();
        double[] min = mu.getMinimumValues(front, numberObjectives);
        for (int i = 0; i < min.length; i++) {
            System.out.println("->" + min[i] + ", ");
        }
        for (int i = 0; i < front.length; i++)
            results.put(names[i], arredondar(mu.distance(min, front[i]), 4, 0));

        return results;
    }



}
