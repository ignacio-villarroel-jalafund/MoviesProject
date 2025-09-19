package utils.exceptions;

/**
 * Custom exception used when detected or used null values.
 */
public class NullValueException extends AppException{
    public NullValueException(String message) {
        super(message, "NULL_VALUE_ERROR");
    }
}
