package com.stackroute.basics;

import com.stackroute.basics.SortAscNumber;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortAscNumberAppTests {
    private ByteArrayOutputStream outStream;
    private SortAscNumber sortAscNumber;
    private String message = "Check whether the output string is of same format";

    @BeforeEach
    public void setUp() {
        sortAscNumber = new SortAscNumber();
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    public void tearDown() {
        sortAscNumber = null;
        outStream = null;
    }

    @Test
    public void givenFourIntegersWhenSortedAscendingThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("12 13 14 15".getBytes()));
        sortAscNumber.getNumbers();
        assertEquals("Sorted:{12,13,14,15}", outStream.toString().trim().replaceAll(".*\n", ""), message);
    }

    @Test
    public void givenFourNegativeIntegersWhenSortedAscendingThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("-26 -31 -2 -42".getBytes()));
        sortAscNumber.getNumbers();
        assertEquals("Sorted:{-42,-31,-26,-2}", outStream.toString().trim().replaceAll(".*\n", ""), message);
    }

    @Test
    public void givenFourMixedIntegerWhenSortedAscendingThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("967 -250 -48 63".getBytes()));
        sortAscNumber.getNumbers();
        assertEquals("Sorted:{-250,-48,63,967}", outStream.toString().trim().replaceAll(".*\n", ""), message);
    }

    @Test
    public void givenSameTwoPairIntegerssWhenSortedAscendingThenReturnAStringResult() {
        System.setIn(new ByteArrayInputStream("20 55 55 20".getBytes()));
        sortAscNumber.getNumbers();
        assertEquals("Sorted:{20,20,55,55}", outStream.toString().trim().replaceAll(".*\n", ""), message );
    }
}
