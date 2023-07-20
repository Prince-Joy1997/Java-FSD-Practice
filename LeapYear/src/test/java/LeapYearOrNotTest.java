import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeapYearOrNotTest {

    private LeapYearOrNot leapYearOrNot;
    @BeforeEach
    void setUp() {
        leapYearOrNot = new LeapYearOrNot();
    }

    @AfterEach
    void tearDown() {
        leapYearOrNot = null;
    }

    @Test
    void isLeapYearTest() {
        String actualValue = leapYearOrNot.isLeapYear(2004);
        Assertions.assertEquals(true,"Leap year".equals(actualValue));
    }
}