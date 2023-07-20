package in.stackroute.ust;

import in.stackroute.ust.domain.Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Inventory obj = new Inventory();

        System.out.println("Inventory management application - proptotype 1.0");

        // this will be the main entry point for the application,
        // this will be a menu-driven application
        // the menu will have the following options:
        // 1. Add item
        // 2. Search item
        // 3. Display all items
        // 4. Exit

        while(true) {

            //Creating menu
            System.out.println("\n \n 1. Add item");
            System.out.println("2. Search item");
            System.out.println("3. Display all items");
            System.out.println("4. Exit\n \n ");

            System.out.println("Make your choice");
            choice = sc.nextInt();


            switch (choice) {


                case 1:
                        obj.addItem();
                    break;


                case 2:
                    obj.searchItem();
                    break;


                case 3:
                    obj.printAllItems();
                    break;


                case 4:
                    System.exit(0);


                default:
                    System.out.println("**************************************************");
                    System.out.println("\n\nInvalid choice!!! Please make a valid choice. \n\n");
                    System.out.println("**************************************************");

            }
        }
    }

}