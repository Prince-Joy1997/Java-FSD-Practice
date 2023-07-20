package in.stackroute.ust;

import java.io.Console;
import java.util.Scanner;

public class ArithematicOperations {

    public void collectInput() throws NumberFormatException {
        int num1 = 0;
        int num2 = 0;
        //Console console = System.console();
        Scanner console = new Scanner(System.in);

        System.out.println("Please provide values for the operation");

        System.out.println("Enter the first number: ");
        String strNumber1 = console.nextLine();
        num1 = Integer.parseInt(strNumber1);

        System.out.println("Enter the second number: ");
        String strNumber2 = console.nextLine();
        num2 = Integer.parseInt(strNumber2);

        System.out.printf("Dividing %d with %d%n", num1, num2);
        int result = divide(num1, num2);
        System.out.printf("Result is %d%n", result);
    }

    public int divide(int a, int b) {
        int result = 0;
        try {
            result = a / b;
        } catch(ArithmeticException e) {
            System.err.println("Exception while dividing: " + e.getMessage());
        }
        return result;
    }

}
