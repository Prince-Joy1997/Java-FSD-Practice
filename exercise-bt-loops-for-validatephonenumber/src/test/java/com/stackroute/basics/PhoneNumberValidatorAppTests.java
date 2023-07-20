package com.stackroute.basics;


import com.stackroute.basics.PhoneNumberValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberValidatorAppTests {
    private static final String VALID = "Valid";
    private static final String INVALID = "Invalid";
    private static final String EMPTY = "Empty string";
    private static String input = "";
    private static final String MESSAGE_ONE = "Phone number is valid";
    private static final String MESSAGE_TWO = "Phone number is invalid";
    private static final String MESSAGE_THREE = "Input string is empty";
    private ByteArrayOutputStream myOutStream;
    private ByteArrayInputStream myInputStream;
    private static final String VALID_VALUES = "99-080-99889";
    private static final String INVALID_VALUES = "99-009-78u888";
    private static final String EMPTY_VALUES = "";

    @BeforeEach
    public void setUp() {
        myOutStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOutStream));
    }

    @AfterEach
    public void tearDown() {
        myOutStream = null;
    }

    @Test
    public void givenValidValuesWhenCheckedThenDisplayValid() {
        input = VALID_VALUES;
        myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);

        PhoneNumberValidator.main(null);
        String actual = myOutStream.toString().toLowerCase().replaceAll("\\s+", "");
        assertEquals(VALID.toLowerCase().replaceAll("\\s+", ""), actual, MESSAGE_ONE);
    }

    @Test
    public void givenInvalidValuesWhenCheckedThenDisplayInvalid() {
        input = INVALID_VALUES;
        myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);

        PhoneNumberValidator.main(null);
        String actual = myOutStream.toString().toLowerCase().replaceAll("\\s+", "");
        assertEquals(INVALID.toLowerCase().replaceAll("\\s+", ""), actual, MESSAGE_TWO);
    }

    @Test
    public void givenEmptyValuesWhenCheckedThenDisplayEmpty() {
        input = EMPTY_VALUES + "\n";
        myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);

        PhoneNumberValidator.main(null);
        String actual = myOutStream.toString().toLowerCase().replaceAll("\\s+", "");
        assertEquals(EMPTY.toLowerCase().replaceAll("\\s+", ""), actual, MESSAGE_THREE);
    }
}
