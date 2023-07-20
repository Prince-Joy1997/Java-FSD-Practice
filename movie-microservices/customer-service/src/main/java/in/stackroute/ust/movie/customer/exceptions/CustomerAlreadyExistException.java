package in.stackroute.ust.movie.customer.exceptions;

public class CustomerAlreadyExistException extends RuntimeException{

    private String uri;

    public CustomerAlreadyExistException(String message, String uri) {
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
