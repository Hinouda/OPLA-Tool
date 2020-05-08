package br.ufpr.dinf.gres.core.jmetal4.encodings.solutionType;

import br.ufpr.dinf.gres.common.Variable;
import br.ufpr.dinf.gres.core.jmetal4.core.Problem;
import br.ufpr.dinf.gres.core.jmetal4.core.SolutionType;
import br.ufpr.dinf.gres.core.jmetal4.problems.OPLA;

/**
 * Class representing the solution type of solutions composed of Architecture
 * variables
 */

public class ArchitectureSolutionType extends SolutionType {

    public ArchitectureSolutionType(Problem problem) {
        super(problem);
    }

    public Variable[] createVariables() {
        Variable[] variables = new Variable[problem_.getNumberOfVariables()];
        for (int var = 0; var < problem_.getNumberOfVariables(); var++)
            if (problem_.getName().equals("OPLA")) {
                variables[var] = ((OPLA) problem_).architecture_.deepCopy();
            }
        return variables;
    }

}
