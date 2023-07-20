package in.stackroute.ust.domain;

import in.stackroute.ust.Main;

import java.util.Scanner;

public class Inventory {
    // class used to manage the items in the inventory
    Main main = new Main();
    Item[] items = new Item[10];
    Scanner sc = new Scanner(System.in);
    public void addItem() {

        System.out.println("Enter the number of Items to be added : ");

            int k = sc.nextInt();

        for(int n = 0; n < k; n++) {

            items[n] = new Item();
            System.out.println("Enter the Item to be added : ");
            System.out.println("*************************************\n\n");
            System.out.println("Enter Item ID : ");
            items[n].setItem_id(n);
            System.out.println("Enter Item Name : ");
            items[n].setItem_Name(sc.next());
            System.out.println("Enter Item Description : ");
            items[n].setItem_Description(sc.next());
            System.out.println("Enter Item Price");
            items[n].setItem_Price(sc.nextInt());
            System.out.println("Enter Item Quantity");
            items[n].setItem_Quantity(sc.nextInt());

        }

    }

    public void searchItem() {


        System.out.println("Enter the product to be search : ");
        String search = sc.next();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s", "Item ID", "NAME", "Description", "price", "Quantity");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int i = 0; i < items.length; i ++){
            if (items[i] == null){
                System.out.println("The product not found");
                break;
            }
            else if (items[i].getItem_Name().equalsIgnoreCase(search)) {

                System.out.println();
                System.out.format("%15s %15s %15s %15s %15s",items[i].getItem_id(),items[i].getItem_Name(),items[i].getItem_Description(),items[i].getItem_Price(),items[i].getItem_Quantity());
                System.out.println();
            }
        }

    }

    public void printAllItems() {

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s", "Item ID", "NAME", "Description", "price", "Quantity");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for(Item item:items){
            if (item == null){
                break;
            }
            System.out.format("%15s %15s %15s %15s %15s",item.getItem_id(),item.getItem_Name(),item.getItem_Description(),item.getItem_Price(),item.getItem_Quantity());
            System.out.println();
        }

    }


}
