package com.stackroute.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.stackroute.basics.Calculator;
import org.junit.jupiter.api.*;

public class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void givenTwoIntegersAndOperatorCaseWhenAddedThenReturnAStringResult() {
        assertEquals("3 + 5 = 8", calculator.calculate(3, 5, 1), "Check whether switch case 1 is add and the print result in expected form");
        assertEquals("-4 + 4 = 0", calculator.calculate(-4, 4, 1), "Check whether switch case 1 is add and the print result in expected form");
    }

    @Test
    public void givenTwoIntegersAndOperatorCaseWhenSubtractedThenReturnAStringResult() {
        assertEquals("6 - 3 = 3", calculator.calculate(6, 3, 2), "Check whether switch case 2 is subtract and the print result in expected form");
        assertEquals("3 - 5 = -2", calculator.calculate(3, 5, 2), "Check whether switch case 2 is subtract and the print result in expected form");
    }

    @Test
    public void givenTwoIntegersAndOperatorCaseWhenMultipliedThenReturnAStringResult() {
        assertEquals("4 * 50 = 200", calculator.calculate(4, 50, 3), "Check whether switch case 3 is multiply and the print result in expected form");
        assertEquals("-6 * 10 = -60", calculator.calculate(-6, 10, 3), "Check whether switch case 3 is multiply and the print result in expected form");
    }

    @Test
    public void givenTwoIntegersAndOperatorCaseWhenDividedThenReturnAStringResultOrError() {
        assertEquals("50 / 3 = 16", calculator.calculate(50, 3, 4), "Check whether switch case 4 is divide and the print result in expected form");
        assertEquals("-90 / 2 = -45", calculator.calculate(-90, 2, 4), "Check whether switch case 4 is divide and the print result in expected form");
        assertEquals("The divider (secondValue) cannot be zero", calculator.calculate(2, 0, 4), "Check whether switch case 4 is divide and the print result in expected form");
    }

    @Test
    public void givenTwoIntegersAndWrongOperatorCaseThenReturnARetryString() {
        assertEquals("Entered wrong option 5", calculator.calculate(4, 50, 5), "Switch case should have default case to handle wrong case number");
    }
}
