package utils.errorhandler;

import utils.exceptions.EmptyValueException;
import utils.exceptions.InvalidInputException;
import utils.exceptions.NegativeNumbeException;
import utils.exceptions.NullValueException;
import utils.exceptions.ValidationException;

/**
 * Class to handle all the define exceptions of the project.
 */
public class ErrorHandler {
    /**
     * Method tho verify, validate and handle the exceptions in the project.
     * 
     * @param e Error to be handle
     */
    public static void handle(Exception e) {
        if (e instanceof ValidationException) {
            System.err.println("Validation Error - " + e.getMessage());
        } else if (e instanceof NegativeNumbeException) {
            System.err.println("Negative Number Error - " + e.getMessage());
        } else if (e instanceof EmptyValueException) {
            System.err.println("Empty Value Error - " + e.getMessage());
        } else if (e instanceof NullValueException) {
            System.err.println("Null Value Error - " +  e.getMessage());
        } else if (e instanceof InvalidInputException) {
            System.err.println("Invalid Input Error - " + e.getMessage());
        } else {
            System.err.println("Unexpected Error " + e.getMessage());
        }
    }
    
}
