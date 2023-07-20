package in.stackroute.ust;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exception handling demo");
        ArithematicOperations arithematicOperations = new ArithematicOperations();
        try {
            arithematicOperations.collectInput();
        } catch (NumberFormatException e) {
            System.err.println("Exception while collecting input: " + e.getMessage());
        }
    }


}