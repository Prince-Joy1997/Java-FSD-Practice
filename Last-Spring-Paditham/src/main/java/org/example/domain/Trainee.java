package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trainees")
public class Trainee {

    @Id
    private int id;
    private String name;
    private String gender;

    public Trainee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Trainee(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
