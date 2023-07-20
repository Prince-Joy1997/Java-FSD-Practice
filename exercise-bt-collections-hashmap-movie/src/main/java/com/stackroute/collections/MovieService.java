package com.stackroute.collections;

import java.time.LocalDate;
import java.util.*;

/*
This class contains a property called movieMap of type Map
This class contains methods for adding key-value pairs of Movie and its rating to HashMap and
various methods for accessing the keys and values based on some conditions
 */
public class MovieService  {

    private Map<Movie, Integer> movieMap = new LinkedHashMap<>();;

    /**
     * Constructor to create movieMap as an empty  LinkedHashMap object
     */
    public MovieService() {

    }

    /*
    Returns the movieMap object
     */
    public Map<Movie, Integer> getMovieMap() {

        return this.movieMap;

    }

    /*
    Add key-value pairs of Movie-Integer type and returns Set of Map.Entry
     */
    public Set<Map.Entry<Movie, Integer>> addKeyValuePairsToMap(Movie movie, Integer rating) {

        movieMap.put(movie,rating);

        return movieMap.entrySet();
    }

    /*
    Return Set of movie names having rating greater than or equal to given rating
     */
    public List<String> getHigherRatedMovieNames(int rating) {

        List<String> res = new LinkedList<>();
        for (Movie movie : movieMap.keySet()){
            if (movieMap.get(movie) >= rating){
                res.add(movie.getMovieName());
            }
        }

        return res;
    }

    /*
    Return Set of movie names belonging to specific genre
     */
    public List<String> getMovieNamesOfSpecificGenre(String genre) {

        List<String> res = new LinkedList<>();

        for (Movie movie : movieMap.keySet()){

            if (movie.getGenre().contentEquals(genre)){

                res.add(movie.getMovieName());
            }
        }

        return res;
    }

   /*
   Return Set of movie names which are released after Specific releaseDate and having rating less than or equal to 3
    */

    public List<String> getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(LocalDate releaseDate) {

        List<String> res = new LinkedList<>();

        for (Movie movie : movieMap.keySet()){

            if (movie.getReleaseDate().isAfter(releaseDate) && movieMap.get(movie) <= 3){

                res.add(movie.getMovieName());

            }
        }
        return res;
    }

    /*
    Return set of movies sorted by release dates in ascending order.
    Hint: Use TreeMap
     */
    public List<Movie> getSortedMovieListByReleaseDate() {

        List<Movie> res = new LinkedList<>();

        TreeSet<Movie> sortedList = new TreeSet<>();

        sortedList.addAll(movieMap.keySet());

        for (Movie movie : sortedList){
            res.add(movie);
        }

        return res;
    }

    /*
   Return set of movies sorted by rating.
   Hint: Use Comparator and LinkedHashMap
    */
    public Map<Movie, Integer> getSortedMovieListByRating() {

        List list = new LinkedList(movieMap.entrySet());

        Collections.sort(list, new Comparator<>(){
        @Override
        public int compare(Object obj1, Object obj2){
            return ((Comparable)((Map.Entry)(obj1)).getValue()).compareTo(((Map.Entry)(obj2)).getValue());
        }
        });

        HashMap res = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            res.put(entry.getKey(), entry.getValue());
        }

        return res;
    }
}
