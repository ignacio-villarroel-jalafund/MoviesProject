package entity;

import java.util.ArrayList;

/**
 * Class to define the structure to export data of a Customer to an external files.
 */
public class CustomerExport {
    private String customerName;
    private ArrayList<RentalExport> rentalExports;
    private double totalAmount;
    private int frequentRenterPoints;

    /**
     * 
     * @param name Name of the customer
     * @param rentals List of rented movies of the customer.
     * @param amount Amount owned of the customer to the store.
     * @param points Frequent renter points of the user gained by renting regulary and various movies.
     */
    public CustomerExport(String name, ArrayList<RentalExport> rentals, double amount, int points) {
        this.customerName = name;
        this.rentalExports = rentals;
        this.totalAmount = amount;
        this.frequentRenterPoints = points;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public ArrayList<RentalExport> getCustomerRentals() {
        return this.rentalExports;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public int getFrequentRenterPoints() {
        return this.frequentRenterPoints;
    }
}
