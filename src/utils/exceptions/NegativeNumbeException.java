package utils.exceptions;

/**
 * CustoM Exception for negative numbers.
 */
public class NegativeNumbeException extends AppException {
    public NegativeNumbeException(String message) {
        super(message, "NEGATIVE_NUMBER_ERROR");
    }
}
