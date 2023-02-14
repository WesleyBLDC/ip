package willy.exception;

/**
 * This represents the WillyException
 */
public class WillyException extends Exception {
    /**
     * WillyException that throws a message
     * @param message String
     */
    public WillyException(String message) {
        super(message);
    }
}
