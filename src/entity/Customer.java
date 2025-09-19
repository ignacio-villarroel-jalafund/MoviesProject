package entity;

import java.util.ArrayList;

import services.customer.CustomerService;

/**
 * Class to define the variables and methods that a Customer entity needs to have.
 */
public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();
    private CustomerService customerService;

    /**
     * 
     * @param name Name of the customer.
     * @param customerService Service related to handle the customer operations.
     */
    public Customer(String name, CustomerService customerService) {
        this.name = name;
        this.customerService = customerService;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public String statement() {
        return customerService.getStatement(name, rentals);
    }
}
