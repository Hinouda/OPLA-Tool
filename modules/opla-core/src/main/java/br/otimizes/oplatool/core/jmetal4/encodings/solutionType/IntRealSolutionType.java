//  IntRealSolutionType.java
//
//  Author:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
// 
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package br.otimizes.oplatool.core.jmetal4.encodings.solutionType;

import br.otimizes.oplatool.core.jmetal4.core.Problem;
import br.otimizes.oplatool.core.jmetal4.core.SolutionType;
import br.otimizes.oplatool.common.Variable;
import br.otimizes.oplatool.core.jmetal4.encodings.variable.Int;
import br.otimizes.oplatool.core.jmetal4.encodings.variable.Real;

/**
 * Class representing  a solution type including two variables: an integer
 * and a real.
 */
public class IntRealSolutionType extends SolutionType {
    private int intVariables_;
    private int realVariables_;

    public IntRealSolutionType(Problem problem, int intVariables, int realVariables) throws ClassNotFoundException {
        super(problem);
        intVariables_ = intVariables;
        realVariables_ = realVariables;
    } // Constructor

    /**
     * Create variables array
     * @return variables
     */
    public Variable[] createVariables() throws ClassNotFoundException {
        Variable[] variables = new Variable[problem_.getNumberOfVariables()];
        for (int variableIndex = 0; variableIndex < intVariables_; variableIndex++)
            variables[variableIndex] = new Int((int) problem_.getLowerLimit(variableIndex), (int) problem_.getUpperLimit(variableIndex));
        for (int var = intVariables_; var < (intVariables_ + realVariables_); var++)
            variables[var] = new Real(problem_.getLowerLimit(var), problem_.getUpperLimit(var));

        return variables;
    } // createVariables
} // IntRealSolutionType
