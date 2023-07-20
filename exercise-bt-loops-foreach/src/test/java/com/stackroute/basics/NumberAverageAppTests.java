package com.stackroute.basics;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberAverageAppTests {
    private ByteArrayOutputStream outStream;
    private NumberAverage numberAverage;
    private String message = "Check the logic in method findAverage";

    @BeforeEach
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        numberAverage = new NumberAverage();
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    public void tearDown() {
        outStream = null;
        numberAverage = null;
    }

    @Test
    public void givenRandomIntegerArrayThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("5 \n 2 4 9 12 5".getBytes()));
        numberAverage.getArrayValues();
        assertEquals("The average value is: 6", outStream.toString().trim().replaceAll(".*\n", ""), message);
    }

    @Test
    public void givenConsecutiveIntegerArrayThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("6 \n 1 2 3 4 5 6".getBytes()));
        numberAverage.getArrayValues();
        assertEquals("The average value is: 3", outStream.toString().trim().replaceAll(".*\n", ""), message);
    }

    @Test
    public void givenNegativeIntegerArrayThenReturnAStringError() {
        System.setIn(new ByteArrayInputStream("4 \n -12 5 4 3".getBytes()));
        numberAverage.getArrayValues();
        assertEquals("Give proper positive integer values", outStream.toString().trim().replaceAll(".*\n", ""), "Write a condition to check whether the array values are negative");
    }

    @Test
    public void givenEmptyArrayThenReturnAStringError() {
        System.setIn(new ByteArrayInputStream("0 \n ".getBytes()));
        numberAverage.getArrayValues();
        assertEquals("Empty array", outStream.toString().trim().replaceAll(".*\n", ""), "Write a condition to check whether the array input is empty");
    }
}
