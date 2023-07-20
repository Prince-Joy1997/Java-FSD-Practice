package org.example;

import java.io.Serializable;

public class Trainee implements Serializable {

    private static final long serialVersionUID=1L;
    private int traineeId;
    private String traineeName;
    private String Location;
    private Batch batch;

    public Trainee(){
    }

    public Trainee(int traineeId, String traineeName, String location, Batch batch) {
        this.traineeId = traineeId;
        this.traineeName = traineeName;
        Location = location;
        this.batch = batch;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "traineeId=" + traineeId +
                ", traineeName='" + traineeName + '\'' +
                ", Location='" + Location + '\'' +
                ", batch=" + batch +
                '}';
    }
}
