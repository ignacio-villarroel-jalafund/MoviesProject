package utils.exceptions;

/**
 * Custom Exception used when a value is empty.
 */
public class EmptyValueException extends AppException{
    public EmptyValueException(String message) {
        super(message, "EMPTY_VALUE_ERROR");
    }
}
