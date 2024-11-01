//  Int.java
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

package br.otimizes.oplatool.core.jmetal4.encodings.variable;

import br.otimizes.oplatool.common.Configuration;
import br.otimizes.oplatool.common.Variable;
import br.otimizes.oplatool.common.exceptions.JMException;
import br.otimizes.oplatool.core.jmetal4.util.PseudoRandom;

/**
 * This class implements an integer decision variable
 */
public class Int extends Variable {

    private static final long serialVersionUID = -220713455225959427L;
    private int value_;       //Stores the value of the variable
    private int lowerBound_;  //Stores the lower limit of the variable
    private int upperBound_;  //Stores the upper limit of the variable

    public Int() {
        lowerBound_ = java.lang.Integer.MIN_VALUE;
        upperBound_ = java.lang.Integer.MAX_VALUE;
        value_ = 0;
    } // Int

    public Int(int lowerBound, int upperBound) {
        lowerBound_ = lowerBound;
        upperBound_ = upperBound;
        value_ = PseudoRandom.randInt(lowerBound, upperBound);
    } // Int

    public Int(int value, int lowerBound, int upperBound) {
        super();

        value_ = value;
        lowerBound_ = lowerBound;
        upperBound_ = upperBound;
    } // Int

    /**
     * Copy constructor.
     *
     * @param variable Variable to be copied.
     * @throws JMException
     */
    public Int(Variable variable) throws JMException {
        lowerBound_ = (int) variable.getLowerBound();
        upperBound_ = (int) variable.getUpperBound();
        value_ = (int) variable.getValue();
    } // Int

    /**
     * Returns the value of the variable.
     *
     * @return the value.
     */
    public double getValue() {
        return value_;
    } // getValue

    /**
     * Assigns a value to the variable.
     *
     * @param value The value.
     */
    public void setValue(double value) {
        value_ = (int) value;
    } // setValue

    /**
     * Creates an exact copy of the <code>Int</code> object.
     *
     * @return the copy.
     */
    public Variable deepCopy() {
        try {
            return new Int(this);
        } catch (JMException e) {
            Configuration.logger_.severe("Int.deepCopy.execute: JMException");
            return null;
        }
    } // deepCopy

    /**
     * Returns the lower bound of the variable.
     *
     * @return the lower bound.
     */
    public double getLowerBound() {
        return lowerBound_;
    } // getLowerBound

    /**
     * Sets the lower bound of the variable.
     *
     * @param lowerBound The lower bound value.
     */
    public void setLowerBound(double lowerBound) {
        lowerBound_ = (int) lowerBound;
    } // setLowerBound

    /**
     * Returns the upper bound of the variable.
     *
     * @return the upper bound.
     */
    public double getUpperBound() {
        return upperBound_;
    } // getUpperBound

    /**
     * Sets the upper bound of the variable.
     *
     * @param upperBound The new upper bound value.
     */
    public void setUpperBound(double upperBound) {
        upperBound_ = (int) upperBound;
    } // setUpperBound

    /**
     * Returns a string representing the object
     *
     * @return The string
     */
    public String toString() {
        return value_ + "";
    } // toString
} // Int
