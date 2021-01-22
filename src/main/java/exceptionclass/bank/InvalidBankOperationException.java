package exceptionclass.bank;

public class InvalidBankOperationException extends RuntimeException {

    private ErrorCode errorCode;

    public InvalidBankOperationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidBankOperationException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
