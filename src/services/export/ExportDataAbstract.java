package services.export;

import java.util.ArrayList;

import entity.CustomerExport;
import entity.Rental;
import entity.RentalExport;
import services.customer.CustomerService;

/**
 * Abstract class to define the base structure to export the Customer rented movies data.
 */
public abstract class ExportDataAbstract {
    protected CustomerService customerService;

    /**
     * 
     * @param customerService Service needed to calculate the amount owned by the Customer's rented movies.
     */
    public ExportDataAbstract(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 
     * @param name Name of the Customer.
     * @param rentals List of rented movies by the Customer.
     */
    public void exportData(String name, ArrayList<Rental> rentals) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        ArrayList<RentalExport> rentalData = new ArrayList<>();

        for (int i = 0; i < rentals.size(); i++) {
            Rental rentalMovie = rentals.get(i);

            double amount = customerService.calculateAmount(rentalMovie);
            int points = customerService.calculateFrequentRenterPoints(rentalMovie);

            RentalExport exportData = new RentalExport(rentalMovie.getMovie().getTitle(), amount);

            rentalData.add(exportData);

            totalAmount += amount;
            frequentRenterPoints += points;
        }

        CustomerExport export = new CustomerExport(name, rentalData, totalAmount, frequentRenterPoints);
        formatData(export);
    }

    public abstract void formatData(CustomerExport export);
}
