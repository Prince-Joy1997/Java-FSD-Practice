import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomFunctionalInterfaceImplementationTest {

    private CustomFunctionalInterfaceImplementation number;
    @BeforeEach
    public void setUp() {
        number = new CustomFunctionalInterfaceImplementation();
    }
    @Test
    public void testCubing() {
        int input = 3;
        MyFunction<Integer> cubing = number.cubing;
        int output = cubing.toDo(input);
        int expected = 27;
        assertEquals(expected, output);
    }
    @Test
    public void testcaseCheck() {
        String input = "HelloWorld";
        MyFunction<String> caseCheck = number.caseCheck;
        String output = caseCheck.toDo(input);
        String expected = "hELLOwORLD";
        assertEquals(expected, output);
    }
    @Test
    public void testNullInput() {
        String input = null;
        MyFunction<String> caseCheck = number.caseCheck;
        String output = caseCheck.toDo(input);
        String expected = "String is null";
        assertEquals(expected, output);
    }
    @Test
    public void testEmptyInput() {
        String input = "";
        MyFunction<String> caseCheck = number.caseCheck;
        String output = caseCheck.toDo(input);
        String expected = "String is null";
        assertEquals(expected, output);
    }

}
