package com.stackroute.basics;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTests {

    private static final String MESSAGE_ONE = "Should return 1 for valid values";
    private static final String MESSAGE_TWO = "Should return 0 for invalid values";
    private static final String MESSAGE_THREE = "Should return -1 for empty or null values";
    private static PhoneNumberValidator phoneNumberValidator;
    private static final String[] VALID_VALUES = {"99-080-99889", "999-99-99999"};
    private static final String[] INVALID_VALUES = {"99-009-78u888", "9999", "-99-999-999991-", "#$$-5556-999"};
    private static final String[] EMPTY_VALUES = {"", null};

    @BeforeEach
    public void setUp() {
        // This methods runs, before running any one of the test case
        // This method is used to initialize the required variables
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @AfterEach
    public void tearDown() {
        // This method runs, after running all the test cases
        // This method is used to clear the initialized variables
        phoneNumberValidator = null;
    }

    @Test
    public void givenValidValuesWhenCheckedThenReturnOne() {
        assertEquals(1, phoneNumberValidator.validatePhoneNumber(VALID_VALUES[0]), MESSAGE_ONE);
        assertEquals(1, phoneNumberValidator.validatePhoneNumber(VALID_VALUES[1]), MESSAGE_ONE);
    }

    @Test
    public void givenInvalidValuesWhenCheckedThenReturnZero() {
        assertEquals(0, phoneNumberValidator.validatePhoneNumber(INVALID_VALUES[0]), MESSAGE_TWO);
        assertEquals(0, phoneNumberValidator.validatePhoneNumber(INVALID_VALUES[1]), MESSAGE_TWO);
        assertEquals(0, phoneNumberValidator.validatePhoneNumber(INVALID_VALUES[2]), MESSAGE_TWO);
        assertEquals(0, phoneNumberValidator.validatePhoneNumber(INVALID_VALUES[3]), MESSAGE_TWO);
    }

    @Test
    public void givenEmptyOrNullValuesWhenCheckedThenReturnMinusOne() {
        assertEquals(-1, phoneNumberValidator.validatePhoneNumber(EMPTY_VALUES[0]), MESSAGE_THREE);
        assertEquals(-1, phoneNumberValidator.validatePhoneNumber(EMPTY_VALUES[1]), MESSAGE_THREE);
    }
}