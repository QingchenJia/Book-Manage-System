package BookManageSystem.exception;

public class DeleteBorrowedBookException extends RuntimeException{
    public DeleteBorrowedBookException() {
        super();
    }

    public DeleteBorrowedBookException(String message) {
        super(message);
    }
}
