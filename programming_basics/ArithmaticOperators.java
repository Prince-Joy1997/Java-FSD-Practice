public class ArithmaticOperators {

    public static void main(String[] args) {

        System.out.println("**************************");
        System.out.println("Arithmetic Operations");
        System.out.println("**************************");
        operation op = new operation();
        op.sum();
        op.difference();
        op.division();
        op.multiplication();
    }
}
class operation {
    void sum() {
        int a = 20;
        int b = 5;
        int result = 0;
        result = a + b;
        System.out.println("The sum of " + a + " and " + b + " is " + result);
    }

    void difference(){
        int a = 20;
        int b = 5;
        int result = 0;
        result = a - b;
        System.out.println("The difference of " + a + " and " + b + " is " + result);
    }

    void division(){
        float a = 20f;
        float b = 5f;
        float result = 0;
        result = a/b;
        System.out.println("The division of " + a + " and " + b + " is " + result);
    }

    void multiplication(){
        float a = 20f;
        float b = 5f;
        float result = 0;
        result = a*b;
        System.out.println("The multiplication of " + a + " and " + b + " is " + result);
    }

}

