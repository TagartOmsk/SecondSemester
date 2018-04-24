package ru.omsu.imit.matrices;

public class MatrixException extends RuntimeException {
    public MatrixException() {
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixException(String message) {
        super(message);
    }
}
