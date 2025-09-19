package utils.exceptions;

/**
 * Base Exception class to define the structure needed to create custom exceptions.
 */
public class AppException extends RuntimeException {
    private final String errorCode;

    /**
     * 
     * @param message Error message that will be displayed by custom Exception.
     * @param errorCode Error code that will be displayed by the custom Exception.
     */
    public AppException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
