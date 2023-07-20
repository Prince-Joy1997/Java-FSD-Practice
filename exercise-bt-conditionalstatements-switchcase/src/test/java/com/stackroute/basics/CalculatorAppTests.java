package com.stackroute.basics;

import com.stackroute.basics.Calculator;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorAppTests {
    private ByteArrayOutputStream outStream;

    @BeforeEach
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    public void tearDown() {
        outStream = null;
    }

    @Test
    public void givenSystemInputTwoIntegersOperatorCaseAndNoRetryWhenAddedThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("23\n3\n1\nn".getBytes()));
        Calculator.main(null);
        assertEquals("23 + 3 = 26", outStream.toString().trim().replaceAll("(Do you want to try again\\(y/n\\))", "").trim().replaceAll(".*\n", ""), "Check whether the system out statements are in correct order as in PROBLEM.md");
    }

    @Test
    public void givenSystemInputTwoIntegersOperatorCaseAndRetryWhenAddedAndSubtractedThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("23\n3\n1\ny\r45\n10\n2\nn".getBytes()));
        Calculator.main(null);
        assertEquals("45 - 10 = 35", outStream.toString().trim().replaceAll("Do you want to try again\\(y/n\\)", "").trim().replaceAll(".*\n", ""), "Check whether the system out statements are in correct order as in PROBLEM.md");
    }

    @Test
    public void givenSystemInputTwoIntegersWrongOperatorCaseAndNoRetryThenReturnAErrorResult() {
        System.setIn(new ByteArrayInputStream("119\n50\n6\nn".getBytes()));
        Calculator.main(null);
        assertEquals("Entered wrong option 6", outStream.toString().trim().replaceAll("Do you want to try again\\(y/n\\)", "").trim().replaceAll(".*\n", ""), "Check whether the system out statements are in correct order as in PROBLEM.md");
    }

    @Test
    public void givenSystemInputTwoIntegersOperatorCaseAndNoRetryWhenDividedThenReturnAErrorResult() {
        System.setIn(new ByteArrayInputStream("57\n0\n4\nn".getBytes()));
        Calculator.main(null);
        assertEquals("The divider (secondValue) cannot be zero", outStream.toString().trim().replaceAll("Do you want to try again\\(y/n\\)", "").trim().replaceAll(".*\n", ""), "Make sure your logic check for undefined problem in division also whether the system out statements are in correct order as in PROBLEM.md");
    }
}
