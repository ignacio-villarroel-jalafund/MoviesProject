package services.export;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.Constants;
import entity.CustomerExport;
import services.customer.CustomerService;
import utils.errorhandler.ErrorHandler;

/**
 * Concrete class to export the Customer's data to a JSON file.
 */
public class ExportDataJson extends ExportDataAbstract{

    public ExportDataJson(CustomerService customerService) {
        super(customerService);
    }

    /**
     *  Method to map, format and write the object to a JSON file.
     */
    @Override
    public void formatData(CustomerExport export) {
        ObjectMapper mapper = new ObjectMapper();
        File folder = new File(Constants.EXPORT_PATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder, Constants.EXPORT_FILE_NAME_JSON);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, export);
        } catch (Exception e) {
            ErrorHandler.handle(e);
        }
        System.out.println("Data exported to JSON correctly");
    }
    
}
