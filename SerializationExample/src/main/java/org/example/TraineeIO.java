package org.example;

import javax.imageio.IIOException;
import java.io.*;

public class TraineeIO{
    String filename = "output.ser";
    public void serialization(Trainee trainee) throws IOException{
        try(
                FileOutputStream outputStream = new FileOutputStream(filename);
                ObjectOutputStream stream = new ObjectOutputStream(outputStream)

                ){

            stream.writeObject(trainee);
            stream.flush();
            System.out.println("Object is Serializable");
        }
    }

    Trainee object = null;
    public Trainee deserializable()throws IOException,ClassNotFoundException{


        try(
                FileInputStream inputStream = new FileInputStream(filename);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)

                ){
            object = (Trainee)objectInputStream.readObject();
            System.out.println("Deserialized...");
        }
        return object;
    }
}
