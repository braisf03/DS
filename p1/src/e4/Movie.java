package e4;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Movie {


    private String title;
    private List<MovieRating> movieRatings = new LinkedList<>();

    public Movie(String title) {

        this.title = title;


    }

    public String getTitle() {
        return title;
    }

    public void insertRating(MovieRating movieRating) {

        this.movieRatings.add(movieRating);


    }

    private boolean isRated() {

        if (movieRatings.isEmpty()) return false;
        for (MovieRating rating : movieRatings) {

            if (rating.getValor() >= 0) {

                return true;
            }
        }
        return false;

    }

    public MovieRating maximumRating() {

        MovieRating maxRating = MovieRating.NOT_RATED;

        if (!isRated()) return maxRating;
        for (MovieRating rating : movieRatings) {
            if (rating.getValor() > maxRating.getValor()) {
                maxRating = rating;
            }
        }
        return maxRating;
    }

    public double averageRating () {

        if(!isRated()) throw new NoSuchElementException();
        double med= 0;
        int counter= 0;
        for (MovieRating rating : movieRatings) {
            if(rating.getValor() >= 0){
                med += rating.getValor();
                counter++;
            }

        }
        return (med/ counter);
    }

}
