package in.stackroute.ust.movie.exception;

public class MovieNotFoundException extends RuntimeException{

    private String uri;

    public MovieNotFoundException(String message, String uri) {
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

}
