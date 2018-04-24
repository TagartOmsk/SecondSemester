package ru.omsu.imit.matrices;

public interface IMatrix {
    double get(int x, int y) throws WrongCoordinatesException;
    void set(double value, int x, int y) throws WrongCoordinatesException;
    double getDeterminant() throws WrongCoordinatesException;
    int length();
}
