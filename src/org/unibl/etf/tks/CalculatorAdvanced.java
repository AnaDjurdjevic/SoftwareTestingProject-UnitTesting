package org.unibl.etf.tks;

/**
 * <h1>Advanced operations calculator</h1> The CalculatorAdvanced program
 * implements a basic Calculator functionality to include advanced calculations.
 * It introduces methods for calculating power, factorial, and checking
 * characteristics of the current value. Supported actions include raising to a
 * power ('0' to '9') and calculating factorial ('!'). Additionally, it can
 * check if the integer part of the current value is an Armstrong number ('A')
 * or a perfect number ('P').
 * <p>
 * 
 * @author AnaDjurdjevic
 * @version 1.0
 */
public class CalculatorAdvanced extends Calculator {

	/**
	 * This method, based on the parameter action, whose allowed values are integer
	 * data in the range from 0 to 9 and the character '!', calculates the power or
	 * factorial of the integer part of the currentValue. The result is then stored
	 * in the currentValue. When calculating the factorial, the value of
	 * currentValue must be in the range [0, 10].
	 * 
	 * @param action The action specifying the type of calculation ('0' to '9' for
	 *               power, '!' for factorial).
	 * @throws NumberNotInAreaException If the currentValue is not in the range [0,
	 *                                  10] for factorial calculation.
	 * @see NumberNotInAreaException
	 * @throws NotSupportedOperationException If the value of the action parameter
	 *                                        is not one of the allowed values.
	 * @see NotSupportedOperationException
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		if (action >= 48 && action <= 57) {

			int value = currentValue.intValue();
			int result = 1;
			for (int i = 0; i < action - 48; i++) {
				result *= value;
			}
			currentValue = (double) result;
		} else if (action == '!') {
			if (currentValue < 0 || currentValue > 10) {
				throw new NumberNotInAreaException();
			} else {
				int number = currentValue.intValue();
				int factorial = 1;
				for (int i = 1; i <= number; i++)
					factorial *= i;
				currentValue = (double) factorial;
			}
		} else {
			throw new NotSupportedOperationException();
		}
	}

	/**
	 * This method, based on the parameter value, whose allowed values are the
	 * characters 'A' and 'P', returns true if the integer part of the
	 * 'currentValue' is an Armstrong number (if the specified value is 'A') or a
	 * perfect number (if the specified value is 'P').
	 * 
	 * @param value The characteristic to check ('A' for Armstrong number, 'P' for
	 *              perfect number).
	 * @return Boolean This returns true if the currentValue has the specified
	 *         characteristic, otherwise false.
	 * @throws NumberNotInAreaException If the currentValue is less than 1.
	 * @see NumberNotInAreaException
	 * @throws NotSupportedOperationException If the value of the value parameter is
	 *                                        not one of the allowed values.
	 * @see NotSupportedOperationException
	 */
	public Boolean hasCharacteristic(char value) throws NumberNotInAreaException, NotSupportedOperationException {
		int originalValue = currentValue.intValue();
		if (originalValue < 1) {
			throw new NumberNotInAreaException();
		} else if (value == 'A') {
			int sum = 0;
			int number = originalValue;
			int numOfDigits = 0;
			while (number > 0){
				numOfDigits++;
				number /= 10;
			}
			number = originalValue;
			while (number > 0) {
				int digit = number % 10;
				int result = 1;
				for (int i = 0; i < numOfDigits; i++) {
					result *= digit;
				}
				sum += result;
				number /= 10;
			}
			if (sum == originalValue) {
				return true;
			}
		} else if (value == 'P') {
			int sumOfFactors = 0;
			for (int i = 1; i <= originalValue / 2; i++) {
				if (originalValue % i == 0)
					sumOfFactors += i;
			}
			if (sumOfFactors == originalValue)
				return true;
		} else {
			throw new NotSupportedOperationException();
		}
		return false;
	}
}
