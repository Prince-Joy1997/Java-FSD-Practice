package com.stackroute.exercises;


import java.io.*;

public class FileMigration {

    //Write here logic to read content of first file and write it in second file
    public String fileContentDuplicator(String firstFile, String secondFile) throws IOException {

        if(secondFile == null || secondFile.isEmpty() || secondFile.equals(" ")){
            return "Given fileName to read or write is empty, null or blank space";
        }
        if(firstFile == null || firstFile.isEmpty() || firstFile.equals(" ")){
            return "Given fileName to read or write is empty, null or blank space";
        }

        int i=0;
        String result= "";
        try(FileInputStream fileInputStream = new FileInputStream(firstFile.trim())) {
            try(BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
                FileOutputStream fileOutputStream = new FileOutputStream(secondFile.trim());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                while (i != 0){
                    i=bufferedInputStream.read();
                    result=result + (char)i;
                    bufferedOutputStream.write(i);
                }
                bufferedOutputStream.flush();
                fileOutputStream.close();
                bufferedOutputStream.close();
            }
        }
        return result;


    }
}