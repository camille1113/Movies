package cs126.demos.jsonapi.starwars;

/**
 * Base class for all application exceptions.
 */
public class ApplicationException extends RuntimeException{
    public ApplicationException(String message) {
        super(message);
    }
}
