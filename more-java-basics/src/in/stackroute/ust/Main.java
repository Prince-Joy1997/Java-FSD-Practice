package in.stackroute.ust;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.moreAboutFunctions();
    }

    void moreAboutFunctions() {
        MoreAboutFunctions mainObject = new MoreAboutFunctions();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide a name: ");
        String name = scanner.nextLine();

        System.out.println("Please provide an age: ");
        int age = scanner.nextInt();

        mainObject.printName(name, age);

        int square = mainObject.square(5);
    }
}