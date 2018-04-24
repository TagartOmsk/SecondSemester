package ru.omsu.imit.matrices;

public class CanNotBeMultipliedxception extends MatrixException {
    public CanNotBeMultipliedxception() {
    }

    public CanNotBeMultipliedxception(String message, Throwable cause) {
        super(message, cause);
    }

    public CanNotBeMultipliedxception(String message) {
        super(message);
    }
}
