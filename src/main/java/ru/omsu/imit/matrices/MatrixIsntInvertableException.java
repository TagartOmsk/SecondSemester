package ru.omsu.imit.matrices;

public class MatrixIsntInvertable extends MatrixException{
    public MatrixIsntInvertable() {
    }

    public MatrixIsntInvertable(String message) {
        super(message);
    }

    public MatrixIsntInvertable(String message, Throwable cause) {
        super(message, cause);
    }
}
