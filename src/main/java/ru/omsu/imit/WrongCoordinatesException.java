package ru.omsu.imit;

public class WrongCoordinatesException extends RuntimeException {
    public WrongCoordinatesException() {
    }

    public WrongCoordinatesException(String message) {
        super(message);
    }

    public WrongCoordinatesException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCoordinatesException(Throwable cause) {
        super(cause);
    }
}
