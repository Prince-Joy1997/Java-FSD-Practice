import java.util.Scanner;

public class CustomPrimeNumber {

    boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    void printPrimeNumbers(int start, int end){
        for(int i = start; i <= end; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {

        int first,last,output=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting number : ");
        first = sc.nextInt();
        System.out.println("Enter the Ending number : ");
        last = sc.nextInt();

        System.out.println("Prime Numbers are : ");
        CustomPrimeNumber obj= new CustomPrimeNumber();
        obj.printPrimeNumbers(1,100);
    }
}
