package entity;

/**
 * Class where is defined the values needed to create a Rental correctly.
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    /**
     * 
     * @param movie The data of the movie that is going to be rented.
     * @param daysRented Amount of days that the movies is gonna be rented.
     */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
