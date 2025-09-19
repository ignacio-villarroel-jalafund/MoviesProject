import entity.Customer;
import entity.Movie;
import entity.Rental;
import services.customer.CustomerService;
import services.export.ExportDataAbstract;
import services.export.ExportDataJson;
import services.export.ExportDataXml;
import utils.errorhandler.ErrorHandler;
import utils.exceptions.InvalidInputException;
import common.Constants;

/**
 * Main class used to define objects and execute the project.
 */
public class Main {
    protected static Movie justiceLeague = new Movie("Zack Snyder's Justice League", 0);
    protected static Movie terminator = new Movie("Terminator", 0);
    protected static Movie soul = new Movie("Soul", 2);

    protected static Rental justiceLeagueRental = new Rental(justiceLeague, 5);
    protected static Rental terminatoRental = new Rental(terminator, 1);
    protected static Rental soulRental = new Rental(soul, 3);

    protected static CustomerService customerService = new CustomerService();

    private static ExportDataAbstract exportData;

    /**
     * Static method to define in which type of file the data of the Customer will be exported.
     */
    protected static void defineExportData() {
        if (Constants.EXPORT_DATA_TYPE.toLowerCase().equals("json")) {
            exportData = new ExportDataJson(customerService);
        } else if (Constants.EXPORT_DATA_TYPE.toLowerCase().equals("xml")) {
            exportData = new ExportDataXml(customerService);
        } else {
            throw new InvalidInputException("Invalid File Type Export Value");
        }
    }

    public static void main(String[] args) {
        try {
            String customerName = "Test";
            Customer customer = new Customer(customerName, customerService);
            defineExportData();
            customer.addRental(justiceLeagueRental);
            customer.addRental(terminatoRental);
            customer.addRental(soulRental);
            System.out.println(customer.statement());
            exportData.exportData(customer.getName(), customer.getRentals());
        } catch (Exception e) {
            ErrorHandler.handle(e);
        }
    }
}
