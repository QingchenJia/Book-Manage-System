package BookManageSystem.exception;

public class DeleteNoEmptyTypeException extends RuntimeException{
    public DeleteNoEmptyTypeException() {
        super();
    }

    public DeleteNoEmptyTypeException(String message) {
        super(message);
    }
}
