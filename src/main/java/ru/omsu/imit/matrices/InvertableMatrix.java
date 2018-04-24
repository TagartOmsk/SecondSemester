package ru.omsu.imit.matrices;

public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    public InvertableMatrix() {
        this(1,1);
    }

    public InvertableMatrix(int size, double... args){
        super(size, args);
        if (Math.abs(this.getDeterminant()) < 1e-9) throw new MatrixIsntInvertableException();
    }

    public InvertableMatrix(int size){
        super(size);
        for(int i = 0; i < this.size; i++){
            this.set(1, i, i);
        }
    }
    public InvertableMatrix(Matrix puper){
        this(puper.size, puper.array);
    }

    public Matrix invert() throws MatrixIsntInvertableException{
        Matrix invert = new InvertableMatrix(this.size);
        Matrix computing = new Matrix(this);
        double temp = 0, dtemp = 0, det = 1;
        int position = 0;

        for (int k = 0; k < size; k++) {
            position = k;
            for (int i = 0; i < size; i++) {
                if (computing.get(i, k) != 0) {
                    position = i;
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

                    dtemp = invert.get(k, i);
                    invert.set(invert.get(position, i), k, i);
                    invert.set(dtemp, position, i);
                }
                det *= -1;
            }

            temp = computing.get(k, k);
            det *= temp;
            for (int i = k + 1; i < size; i++) {
                dtemp = computing.get(i, k) / temp;
                for (int j = k; j < size; j++) {
                    computing.set(computing.get(i, j) - computing.get(k, j) * dtemp, i, j);
                    invert.set(invert.get(i, j) - invert.get(k, j) * dtemp, i, j);
                }
                if (k > 0) {
                    for (int j = 0; j < k; j++) {
                        invert.set(invert.get(i, j) - invert.get(k, j) * dtemp, i, j);
                    }
                }
            }
        }
        if (!this.isCalculated) {
            this.determinant = det;
        }
        dtemp = 0;
        temp = 0;

        for (int k = size - 1; k >= 0; k--) {
            temp = computing.get(k, k);
            for (int i = k - 1; i >= 0; i--) {
                dtemp = computing.get(i, k) / temp;
                for (int j = 0; j < size; j++) {
                    invert.set(invert.get(i, j) - invert.get(k, j) * dtemp, i, j);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                invert.set(invert.get(i, j) / computing.get(i, i), i, j);
            }
            computing.set(1, i, i);
        }
        return invert;
    }
}