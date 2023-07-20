package org.example;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       Batch batch = new Batch(101,"javaFSD", LocalDate.of(2023,02,20),LocalDate.of(2023,06,20));
       Trainee trainee = new Trainee(1,"John","India",batch);
       TraineeIO io = new TraineeIO();

       io.serialization(trainee);

       Trainee res = io.deserializable();
        System.out.println(res);


    }
}