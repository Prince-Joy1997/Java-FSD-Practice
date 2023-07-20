package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Campus_Training_Guidelines {

    private String fileName;

    public Campus_Training_Guidelines(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(String data) throws IOException {

        FileWriter writer = new FileWriter(fileName, true);
        writer.write(data);
        writer.flush();
        writer.close();

    }

    public void readFromFile() throws IOException{

        FileReader fileReader = new FileReader(fileName);
        int read = 0;
        while (read != -1) {

            read = fileReader.read();
            System.out.print((char)read);
        }
        fileReader.close();
    }
}


