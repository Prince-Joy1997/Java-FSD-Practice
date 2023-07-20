package com.stackroute.ust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterCombinationsTest {

    private LetterCombinations combinations;
    @BeforeEach
    void setUp() {
        combinations = new LetterCombinations();

    }

    @AfterEach
    void tearDown() {
        combinations = null;
    }

    @Test
    void testgenerateCombinations(){
        Assertions.assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]",combinations.generateCombinations("23").toString());
    }
}