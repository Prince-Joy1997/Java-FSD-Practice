package com.stackroute.fileio;


import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicateLines {
    //write logic to read data from input.txt and  write result to output.txt


    public void removeDuplicateLines() throws IOException {

        // With HashSet

        Set<String> set = new HashSet<>();

        Scanner input = new Scanner(new File("input.txt"));
        FileWriter fw = new FileWriter("output.txt");

        while (input.hasNextLine()){

            set.add(input.nextLine());

        }

        for (String i : set){

            fw.append(i + "\n");

        }

            fw.flush();

        //Without HashSet

//        PrintWriter pw = new PrintWriter("output.txt");
//
//        BufferedReader br1 = new BufferedReader(new FileReader("input.txt"));
//
//        String line1 = br1.readLine();
//gbh
//
//        while(line1 != null)
//        {
//            boolean flag = false;
//
//
//            BufferedReader br2 = new BufferedReader(new FileReader("output.txt"));
//
//            String line2 = br2.readLine();
//
//
//            while(line2 != null)
//            {
//
//                if(line1.equals(line2))
//                {
//                    flag = true;
//                    break;
//                }
//
//                line2 = br2.readLine();
//
//            }
//
//
//            if(!flag){
//                pw.println(line1);
//
//
//                pw.flush();
//            }
//
//            line1 = br1.readLine();
//
//        }
//
//
//        br1.close();
//        pw.close();
//
//        System.out.println("File operation performed successfully");



    }
}
