package com.stackroute.collections;

import java.time.LocalDate;
import java.util.Objects;

/*
Movie class has four fields- movieId,movieName, genre and releaseDate
This class should be of Comparable type comparing movies based on releaseDate
 */
public class Movie implements Comparable<Movie>{

    private int movieId;
    private String movieName;
    private String genre;
    private  LocalDate releaseDate;

    public Movie(int movieId, String movieName, String genre, LocalDate releaseDate) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.releaseDate = releaseDate;

    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }



    @Override
    public int compareTo(Movie obj){

        return this.getReleaseDate().compareTo(obj.getReleaseDate());

    }

    @Override
    public String toString() {
        return String.format("movieId="+ movieId +", movieName="+ movieName +", genre="+ genre +"releaseDate="+ releaseDate);
    }

}
