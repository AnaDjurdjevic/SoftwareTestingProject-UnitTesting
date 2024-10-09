package org.unibl.etf.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.unibl.etf.tks.CalculatorAdvanced;
import org.unibl.etf.tks.NotSupportedOperationException;
import org.unibl.etf.tks.NumberNotInAreaException;

class CalculatorAdvancedTest {

	private CalculatorAdvanced calculatorAdv = new CalculatorAdvanced();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculatorAdv.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("testCalculateAdvancedData")
	void testCalculateAdvanced(Double currentValue, char action, Object expected) 
			throws NumberNotInAreaException, NotSupportedOperationException {
		calculatorAdv.setCurrentValue(currentValue);
		if (expected instanceof Double) {
			calculatorAdv.calculateAdvanced(action);
			assertThat(calculatorAdv.getCurrentValue(), is((Double) expected));
		} else if (expected instanceof Class<?>) {
			assertThrows((Class<? extends Throwable>) expected, () -> calculatorAdv.calculateAdvanced(action));
		}
	}

	private static Stream<Arguments> testCalculateAdvancedData() {
		return Stream.of(
				Arguments.of(3.2, '0', 1.0), 
				Arguments.of(3.2, '9', 19683.0), 
				Arguments.of(3.2, '!', 6.0),
				Arguments.of(0.0, '!', 1.0), 
				Arguments.of(-0.1, '!', NumberNotInAreaException.class),
				Arguments.of(10.0, '!', 3628800.0), 
				Arguments.of(11.0, '!', NumberNotInAreaException.class),
				Arguments.of(1.2, '*', NotSupportedOperationException.class));
	}

	@ParameterizedTest
	@MethodSource("testHasCharacteristicData")
	void testHasCharacteristic(Double currentValue, char value, Object expected)
			throws NumberNotInAreaException, NotSupportedOperationException {
		calculatorAdv.setCurrentValue(currentValue);
		if (expected instanceof Boolean) {
			calculatorAdv.hasCharacteristic(value);
			assertThat(calculatorAdv.hasCharacteristic(value), is((Boolean) expected));
		} else if (expected instanceof Class<?>) {
			assertThrows((Class<? extends Throwable>) expected, () -> calculatorAdv.hasCharacteristic(value));
		}
	}

	private static Stream<Arguments> testHasCharacteristicData() {
		return Stream.of(
				Arguments.of(0.2,'A',NumberNotInAreaException.class),
				Arguments.of(1.4,'A', true),
				Arguments.of(153.4,'A', true),
				Arguments.of(13.4,'A', false),
				Arguments.of(28.0,'P', true),
				Arguments.of(90.2,'P',false),
				Arguments.of(90.2,'j',NotSupportedOperationException.class)
				);
	}

}
