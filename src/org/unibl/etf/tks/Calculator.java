package org.unibl.etf.tks;

/**
 * <h1>Arithmetic operations calculator</h1>
 * The Calculator program implements a basic calculator with the ability to perform arithmetic operations.
 * It allows users to manipulate and retrieve the current value stored in the calculator.
 * The supported operations include addition, subtraction, multiplication, and division.
 * In case of division, it handles division by zero by throwing a DivisionByZeroException.
 * Unsupported operations trigger a NotSupportedOperationException.
 * <p>
 * @author AnaDjurdjevic
 * @version 1.0
 */
public class Calculator {
	protected Double currentValue;
	
	/**
	 * Creates a new instance of the Calculator class.
	 * The Calculator is initialized with a default currentValue of 0.0.
	 * This constructor sets up the initial state of the Calculator.
	 */
	public Calculator() {
		currentValue = 0.0;
	}

	/**
	 * This method is used to get the currentValue stored in the Calculator 
	 * @return Double This returns the currentValue stored in the Calculator
	 */
	public Double getCurrentValue() {
		return currentValue;
	}

	/**
	 * This method is used to set the currentValue of the Calculator to the specified value.
	 * @param currentValue This is the new value to be set as the currentValue of the Calculator.
	 */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

	/**
	 * Method that, based on the parameter operator, applies a given operation,
	 * where the first operand is the currentValue, 
	 * and the second operand is the parameter of the method, value. 
	 * After applying the operation, the result is stored in the currentValue.
	 * @param value This is the second operand(Double) of the calculation. 
	 * @param operator This is the operator(char) specifying the type of operation ('+', '-', '*', '/').
	 * @throws NotSupportedOperationException If the value of the operator parameter is not one of the allowed values.
	 * @see NotSupportedOperationException
	 * @throws NullPointerException If the value parameter is null.
	 * @see NullPointerException
	 * @throws DivisionByZeroException In case of division by zero.
	 * @see DivisionByZeroException
	 */
	public void calculate(Double value, char operator) throws NotSupportedOperationException, NullPointerException, DivisionByZeroException{
		if (value == null)
		{
			throw new NullPointerException();
		}
		else if(operator == '+')
		{
			currentValue = currentValue + value;
		}
		else if (operator == '-')
		{
			currentValue = currentValue - value;
		}
		else if(operator == '*')
		{
			currentValue = currentValue * value;
		}
		else if(operator == '/')
		{
			if(value == 0.0)
				throw new DivisionByZeroException();
			currentValue = currentValue / value;
		}
		else {
			throw new NotSupportedOperationException();
		}
	}
	
}
