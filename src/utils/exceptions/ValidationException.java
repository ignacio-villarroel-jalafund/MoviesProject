package utils.exceptions;

/**
 * Custom Exception used when there is an error validating a field.
 */
public class ValidationException extends AppException{
    public ValidationException(String message) {
        super(message, "VALIDATION_ERROR");
    }
}
