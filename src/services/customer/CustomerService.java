package services.customer;

import java.util.ArrayList;

import entity.Movie;
import entity.Rental;

/**
 * Service to calculate and format the user rented movies information and amount
 * owned.
 */
public class CustomerService {
    private final int REGULAR_MOVIE_PRICE = 2;

    /**
     * 
     * @param rental Information about a rented movie and the days rented.
     * @return Returns the amount owned for a rented movie according to their type
     *         and days.
     */
    public double calculateAmount(Rental rental) {
        double amount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += REGULAR_MOVIE_PRICE;
                if (rental.getDaysRented() > 2)
                    amount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (rental.getDaysRented() > 3)
                    amount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }

        return amount;
    }

    /**
     * 
     * @param rental Information about a rented movie and the days rented.
     * @return Returns the Frequent Renter Points that the user won by renting a
     *         movie.
     */
    public int calculateFrequentRenterPoints(Rental rental) {
        int points = 0;

        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                || rental.getMovie().getPriceCode() == Movie.CHILDREN) {
            points++;
        }

        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
            points++;
        }

        return points;
    }

    /**
     * 
     * @param totalAmount          Total amount of money of all the movies rented by
     *                             the customer.
     * @param frequentRenterPoints Total amount of points earned for all the rented
     *                             movies by the customer.
     * @param result               StringBuilder object to append and add all the
     *                             information of each rented movie, owned money and
     *                             points gained of the customer.
     * @return Returns the formated data with all the information of the rented
     *         movies of the customer.
     */
    private String printResult(double totalAmount, int frequentRenterPoints, StringBuilder result) {
        StringBuilder finalResult = result;

        finalResult.append("Amount owed is ").append(totalAmount)
                .append("\n");
        finalResult.append("You earned ").append(frequentRenterPoints)
                .append(" frequent renter points");

        return finalResult.toString();
    }

    /**
     * 
     * @param name    Customer name
     * @param rentals List of rented movies by the customer.
     * @return Returns the statement formated with all the information about the
     *         rented movies of the customer.
     */
    public String getStatement(String name, ArrayList<Rental> rentals) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();

        result.append("Rental Record for ").append(name).append("\n");

        for (int i = 0; i < rentals.size(); i++) {
            Rental rentalMovie = rentals.get(i);

            double amount = calculateAmount(rentalMovie);
            int points = calculateFrequentRenterPoints(rentalMovie);

            result.append("\t").append(rentalMovie.getMovie().getTitle())
                    .append("\t").append(amount).append("\n");

            totalAmount += amount;
            frequentRenterPoints += points;
        }

        return printResult(totalAmount, frequentRenterPoints, result);
    }
}
