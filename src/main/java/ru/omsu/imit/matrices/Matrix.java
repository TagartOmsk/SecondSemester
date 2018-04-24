package ru.omsu.imit.matrices;

import java.io.Serializable;
import java.util.Arrays;

public class Matrix implements IMatrix, Serializable {
    protected double[] array;
    protected int size;
    protected double determinant;
    protected boolean isCalculated = false;

    public Matrix(int size, double... args) {
        this.array = new double[size * size];
        this.size = size;
        for (int i = 0; i < Math.min(this.array.length, args.length); i++) {
            this.array[i] = args[i];
        }
        isCalculated = false;
    }

    public Matrix() {
        this(1,1);
    }

    public Matrix(int size) {
        this(size, new double[size * size]);
    }



    public Matrix(Matrix orig) {
        this.size = orig.size;
        this.array = orig.array.clone();
    }

    public int length() {
        return size;
    }

    public double get(int x, int y) throws WrongCoordinatesException {
        if (x * size + y >= size * size) throw new WrongCoordinatesException();
        return array[x * size + y];
    }


    public void set(double value, int x, int y) throws WrongCoordinatesException {
        try {
            array[x * size + y] = value;
            isCalculated = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new WrongCoordinatesException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Matrix)) return false;

        Matrix matrix = (Matrix) o;

        if (size != matrix.size) return false;
        for(int i = 0; i < array.length; i++){
            if(Math.abs(array[i] - matrix.array[i]) > 1e-9)return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }

    public double getDeterminant() throws WrongCoordinatesException {
        if (isCalculated) {
            return this.determinant;
        }

        Matrix computing = new Matrix(this);
        double temp = 0, determinant = 1.0, dtemp = 0;
        int position = 0;
        boolean notNullRow = false;

        for (int k = 0; k < size; k++) {
            position = k;
            for (int i = 0; i < size; i++) {
                if (computing.get(i, k) != 0) {
                    position = i;
                    notNullRow = true;
                    if (position >= k) {
                        break;
                    }
                }
            }
            if (position > k) {
                for (int i = 0; i < size; i++) {
                    dtemp = computing.get(k, i);
                    computing.set(computing.get(position, i), k, i);
                    computing.set(dtemp, position, i);
                }
                determinant *= -1;
            }

            if (!notNullRow) {
                return 0;
            }

            temp = computing.get(k, k);
            determinant *= temp;
            for (int i = k + 1; i < size; i++) {
                dtemp = computing.get(i, k) / temp;
                for (int j = k + 1; j < size; j++) {
                    computing.set(computing.get(i, j) - computing.get(k, j) * dtemp, i, j);
                }
            }
            notNullRow = false;
        }
        this.determinant = determinant;
        isCalculated = true;

        return determinant;
    }

    public Matrix multiply(IMatrix orig) throws CanNotBeMultipliedxception {
        if (orig.length() != size) throw new CanNotBeMultipliedxception();
        Matrix res = new Matrix(size);
        double temp = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp = 0;
                for (int k = 0; k < size; k++) {
                    temp += get(i, k) * orig.get(k, j);
                }
                res.set(temp, i, j);
            }
        }
        return res;
    }

    public boolean isIdentity() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    if (Math.abs(get(i, j) - 1.0) > 1e-9) {
                        return false;
                    }
                } else {
                    if (Math.abs(get(i, j)) > 1e-9) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
