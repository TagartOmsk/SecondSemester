package ru.omsu.imit;

import ru.omsu.imit.matrices.Matrix;

import java.io.*;

public class DemoMatrix {
    public static void toStream(Writer outerWriter, Matrix matrix) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(outerWriter)){
            writer.write(matrix.length() + "\r\n");
            for(int i = 0; i < matrix.length(); i++){
                StringBuilder stemp = new StringBuilder();
                for(int j = 0; j < matrix.length(); j++){
                    stemp.append(matrix.get(i,j));
                    stemp.append(" ");
                }
                writer.write(stemp.toString());
                //writer.write(" ");
            }
            writer.close();
        }
    }

    public static Matrix fromStream(Reader outerReader) throws IOException{
        try(BufferedReader reader = new BufferedReader(outerReader)){
            int size = Integer.parseInt(reader.readLine());
            double [] values = new double[size*size];
            String [] strings = reader.readLine().split(" ");
            for(int i = 0; i < values.length; i++){
                values[i] = Double.parseDouble(strings[i]);
            }
            return new Matrix(size, values);
        }
    }

    public static double sumMatrix(Matrix matrix){
        double res = 0;
        for(int i = 0; i < matrix.length(); i++){
            for(int j = 0; j < matrix.length(); j++){
                res += matrix.get(i,j);
            }
        }
        return res;
    }
}
