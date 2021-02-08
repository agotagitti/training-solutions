package collectionsqueue.job;

public class NoJobException extends RuntimeException {

    public NoJobException(String message) {
        super(message);
    }

    public NoJobException(String message, Throwable cause) {
        super(message, cause);
    }
}
