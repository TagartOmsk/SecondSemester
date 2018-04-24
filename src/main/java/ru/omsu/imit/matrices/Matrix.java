package ru.omsu.imit;

import java.util.Arrays;

public class Matrix implements IMatrix{
    protected double[] array;
    protected int size;

    public Matrix(){
        this.size = 1;
        this.array = new double[size*size];

    }

    public Matrix(int size){
        this.array = new double[size*size];
        this.size = size;
    }

    public Matrix(int size, double...args){
        this.array = new double[size*size];
        this.size = size;
        for(int i = 0; i<Math.min(this.array.length,args.length);i++){
            this.array[i]=args[i];
        }
    }

    public Matrix(Matrix orig){
        this.size = orig.size;
        this.array = orig.array.clone();
    }

    public int length(){
        return size;
    }

    public double get(int x, int y) throws WrongCoordinatesException{
        if(x * size + y >= size * size) throw new WrongCoordinatesException();
        return array[x*size + y];
    }
    //delete nahui
    public double get(int x){
        return array[x];
    }

    public void set(double value, int x, int y) throws WrongCoordinatesException{
        try {
            array[x * size + y] = value;
        }catch(ArrayIndexOutOfBoundsException e){
            throw new WrongCoordinatesException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (size != matrix.size) return false;
        return Arrays.equals(array, matrix.array);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }
/*public double getDeterminant(){
        double[] wArray = this.array.clone();
        double result = 1;
        for(int i = 0; i < size-1; i++){
            for(int j = i; j < size; j++){
                for(int k = size-1; k >= i; k--){
                    wArray[j*size + k]/=wArray[j*size + i];
                }
            }
            for(int j = i+1; j < size; j++){
                for(int k = i; k < size; k++){
                    wArray[j*size + k] -= wArray[i*size + k];
                }
            }
        }
        for(int i = 0; i < size; i++){
            result*=wArray[i*size + i];
        }
        return result;
    }*/
    /*public double getDeterminant(){
        double[] wArray = this.array.clone();
        double result = 1,divCoef = 0;
        for(int step = 0; step < size-1; step++){
            for(int row = step+1; row < size; row++){
                divCoef = wArray[row*size+step]/wArray[step*size+step];
                for(int col = 0; col < size; col++){
                    wArray[row*size+col]-=divCoef*wArray[step*size+col];
                }
            }
        }
        for(int i = 0; i < size; i++){
            result*=wArray[i*size + i];
        }
        return result;
    }*/

    public double getDeterminant(){
        double[] wArray = this.array.clone();
        double result = 1,divCoef = 0;
        for(int step = 0; step < size-1; step++){
            for(int row = step+1; row < size; row++){
                if(wArray[step*size+step]!=0){
                    divCoef = wArray[row*size+step]/wArray[step*size+step];
                }else{
                    for(int i = 0;i < size; i++){
                        double buf = wArray[row*size+i];
                        wArray[row*size+i] = - wArray[step*size+i];
                        wArray[step*size+i] = buf;
                    }
                }
                for(int col = 0; col < size; col++){
                    wArray[row*size+col]-=divCoef*wArray[step*size+col];
                }
            }
        }
        for(int i = 0; i < size; i++){
            result*=wArray[i*size + i];
        }
        return result;
    }
}
