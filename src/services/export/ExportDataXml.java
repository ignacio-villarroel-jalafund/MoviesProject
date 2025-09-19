package services.export;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import common.Constants;
import entity.CustomerExport;
import services.customer.CustomerService;
import utils.errorhandler.ErrorHandler;

/**
 * Concrete class to export the Customer's data to a XML file.
 */
public class ExportDataXml extends ExportDataAbstract {

    public ExportDataXml(CustomerService customerService) {
        super(customerService);
    }

    /**
     *  Method to map, format and write the object to a XML file.
     */
    @Override
    public void formatData(CustomerExport export) {
        XmlMapper mapper = new XmlMapper();
                File folder = new File(Constants.EXPORT_PATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder, Constants.EXPORT_FILE_NAME_XML);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, export);
        } catch (Exception e) {
            ErrorHandler.handle(e);
        }
        System.out.println("Data exported to XML correctly");
    }
}
