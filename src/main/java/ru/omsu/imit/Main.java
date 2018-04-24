package ru.omsu.imit;


import ru.omsu.imit.matrices.InvertableMatrix;
import ru.omsu.imit.matrices.Matrix;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main( String[] args )
    {
        InvertableMatrix A = new InvertableMatrix(3, 2,5,7,6,3,4,5,-2,-3);
        Matrix B = A.invert();
        try {
            DemoMatrix.toStream(new FileWriter("first", false), A);
            DemoMatrix.toStream(new FileWriter("second", false), B);
            Matrix C = DemoMatrix.fromStream(new FileReader("first"));
            Matrix D = DemoMatrix.fromStream(new FileReader("second"));
            System.out.println(C.equals(A));
            System.out.println(D.equals(B));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
