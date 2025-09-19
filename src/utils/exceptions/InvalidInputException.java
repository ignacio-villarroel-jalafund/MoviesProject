package utils.exceptions;

/**
 * Custom Exception used when a user tries to execute an invalid option.
 */
public class InvalidInputException extends AppException{

    public InvalidInputException(String message) {
        super(message, "INVALID_INPUT_ERROR");
    }
}
