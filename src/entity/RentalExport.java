package entity;

/**
 * Class where is defined the structure to export the data of each individual movie rented by a user.
 */
public class RentalExport {
    private String rentalMovieName;
    private double rentalMovieAmount;

    /**
     * 
     * @param name Name of the movie rented.
     * @param amount Amount of money owned by the user that rented the movie.
     */
    public RentalExport(String name, double amount) {
        this.rentalMovieName = name;
        this.rentalMovieAmount = amount;
    }

    public String getRentalMovieName() {
        return this.rentalMovieName;
    }

    public double getRentalMovieAmount() {
        return this.rentalMovieAmount;
    }
}
