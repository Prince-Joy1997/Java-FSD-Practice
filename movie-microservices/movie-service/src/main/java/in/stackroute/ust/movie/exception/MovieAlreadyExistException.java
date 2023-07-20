package in.stackroute.ust.movie.exception;

public class MovieAlreadyExistException extends RuntimeException{

    private String uri;

    public MovieAlreadyExistException(String message, String uri) {
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

}
