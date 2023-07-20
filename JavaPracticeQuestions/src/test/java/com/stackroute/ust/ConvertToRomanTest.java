package com.stackroute.ust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertToRomanTest {

    private ConvertToRoman toRoman;
    @BeforeEach
    void setUp() {
        toRoman = new ConvertToRoman();
    }

    @AfterEach
    void tearDown() {
        toRoman = null;
    }

    @Test
    void testcoversion() {

        Assertions.assertEquals("MCMXCIV",toRoman.coversion(1994));
        Assertions.assertEquals("LVIII",toRoman.coversion(58));
        Assertions.assertEquals("III",toRoman.coversion(3));
    }
}