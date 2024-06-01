package hust.soict.aims.exception;

public class PlayerException extends Exception{
    public PlayerException() {
        super();
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, PlayerException e) {
        super(message, e);
    }
}