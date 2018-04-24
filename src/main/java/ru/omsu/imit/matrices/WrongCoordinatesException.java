package ru.omsu.imit.matrices;

public class WrongCoordinatesException extends MatrixException {
    public WrongCoordinatesException() {
    }

    public WrongCoordinatesException(String message) {
        super(message);
    }

    public WrongCoordinatesException(String message, Throwable cause) {
        super(message, cause);
    }
}
