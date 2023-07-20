package com.stackroute.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.stackroute.basics.SortAscNumber;
import org.junit.jupiter.api.*;

public class SortAscNumberTests {
    public SortAscNumber sortAscNumber;
    private String message = "Check whether the logic of method numberSorter is correct";


    @BeforeEach
    public void setUp() {
        sortAscNumber = new SortAscNumber();
    }

    @AfterEach
    public void tearDown() {
        sortAscNumber = null;
    }

    @Test
    public void givenFourIntegersWhenSortedThenReturnAStringResult() {
        assertEquals("Sorted:{19,23,51,65}", sortAscNumber.numberSorter(23, 51, 65, 19), message);
    }

    @Test
    public void givenFourNegativeIntegersWhenSortedThenReturnAStringResult() {
        assertEquals("Sorted:{-664,-452,-194,-150}", sortAscNumber.numberSorter(-150, -452, -194, -664), message);
    }

    @Test
    public void givenFourMixedIntegersWhenSortedThenReturnAStringResult() {
        assertEquals("Sorted:{-109,-85,31,47}", sortAscNumber.numberSorter(31, -85, 47, -109), message);
    }

    @Test
    public void givenSameTwoPairIntegersWhenSortedThenReturnAStringResult() {
        assertEquals("Sorted:{55,55,97,97}", sortAscNumber.numberSorter(55, 97, 55, 97) , message);
    }
}
