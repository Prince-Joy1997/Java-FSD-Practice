package com.stackroot.ust.domain;

public class Movie {

    private String name;
    private String duration;
    private Actor actor;

    public Movie(){

    }
    public Movie(String name, String duration, Actor actor) {
        this.name = name;
        this.duration = duration;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", actor=" + actor +
                '}';
    }
}
