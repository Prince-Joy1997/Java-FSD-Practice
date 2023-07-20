package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println();
        System.out.println("***********Campus Training Guidelines***********");
        System.out.println();
        Campus_Training_Guidelines fileManager = new Campus_Training_Guidelines("Data.txt");
        char bullet = '\u2023';
        fileManager.writeToFile(bullet + " Be punctual and prepared for class everyday. "+ "\n");
        fileManager.writeToFile(bullet + " Adhere to training session and break timings. "+ "\n");
        fileManager.writeToFile(bullet + " Dress appropriately and adhere tp UST dress code policy. "+ "\n");
        fileManager.writeToFile(bullet + " Ask questions and seek clarifications. "+ "\n");
        fileManager.writeToFile(bullet + " Show courtesy to the speaker and wait your turn. "+ "\n");
        fileManager.readFromFile();

    }
}