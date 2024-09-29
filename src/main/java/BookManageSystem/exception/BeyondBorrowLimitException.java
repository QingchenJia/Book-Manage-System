package BookManageSystem.exception;

public class BeyondBorrowLimitException extends RuntimeException {
    public BeyondBorrowLimitException() {
        super();
    }

    public BeyondBorrowLimitException(String message) {
        super(message);
    }
}
