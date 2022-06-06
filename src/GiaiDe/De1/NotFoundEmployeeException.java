package GiaiDe.De1;

public class NotFoundEmployeeException extends Exception{

    public NotFoundEmployeeException() {
    }

    public NotFoundEmployeeException(String message) {
        super(message);
    }
}
