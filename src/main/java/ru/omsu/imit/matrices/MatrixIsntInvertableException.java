package ru.omsu.imit.matrices;

public class MatrixIsntInvertableException extends MatrixException{
    public MatrixIsntInvertableException() {
    }

    public MatrixIsntInvertableException(String message) {
        super(message);
    }

    public MatrixIsntInvertableException(String message, Throwable cause) {
        super(message, cause);
    }
}
