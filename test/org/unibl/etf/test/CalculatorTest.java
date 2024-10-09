package org.unibl.etf.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.unibl.etf.tks.Calculator;
import org.unibl.etf.tks.DivisionByZeroException;
import org.unibl.etf.tks.NotSupportedOperationException;

class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculator.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertThat(calculator, is(notNullValue()));
		assertThat(calculator.getCurrentValue(), is(equalTo(0.0)));
		
	}

	@Test
	void testGetCurrentValue() {
		assertThat(calculator.getCurrentValue(), is(equalTo(0.0)));
	}

	@Test
	void testSetCurrentValue() {
		calculator.setCurrentValue(3.2);
		assertThat(calculator.getCurrentValue(), is(equalTo(3.2)));
	}

	@ParameterizedTest
	@MethodSource("testCalculateData")
	void testCalculate(Double currentValue, char operator, Double value, Object expected) throws NotSupportedOperationException, NullPointerException, DivisionByZeroException{
		calculator.setCurrentValue(currentValue);
		if (expected instanceof Double) {
            calculator.calculate(value, operator);
            assertThat(calculator.getCurrentValue(), is((Double)expected));
        } else if (expected instanceof Class<?>) {
            assertThrows((Class<? extends Throwable>) expected, () -> calculator.calculate(value, operator));
        }
	}
	
	private static Stream<Arguments>testCalculateData()
	{
		return Stream.of(
				Arguments.of(5.0, '+', 3.0, 8.0),
                Arguments.of(10.0, '-', 3.0, 7.0),
                Arguments.of(2.0, '*', 4.0, 8.0),
                Arguments.of(6.0, '/', 2.0, 3.0),
                Arguments.of(10.0, '/', 0.0, DivisionByZeroException.class),
                Arguments.of(null, '+', 5.0, NullPointerException.class),
                Arguments.of(5.0, '+', null, NullPointerException.class),
                Arguments.of(7.0, '$', 3.0, NotSupportedOperationException.class));
	}

}
