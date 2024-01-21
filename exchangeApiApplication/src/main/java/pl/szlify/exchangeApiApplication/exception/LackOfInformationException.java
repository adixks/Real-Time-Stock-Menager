package pl.szlify.exchangeApiApplication.exception;

public class LackOfInformationException extends RuntimeException {
    public LackOfInformationException() {
        super("Lack of information");
    }

    public LackOfInformationException(String message) {
        super(message);
    }
}
