package ru.omsu.imit;


public class Main
{
    public static void main( String[] args )
    {
//        System.out.println(new InvertableMatrix(3,0,2,3,0,5,6,7,8,9).getDeterminant());
        //System.out.println(new Matrix(3,0,2,3,4,5,6,7,8,9).getDeterminant());//answer 3
        //System.out.println(new Matrix(4,0,2,6,0,5,6,7,8,9,7,5,4,6,4,1,2,5).getDeterminant());
        //System.out.println(new Matrix(3,0,2,3,0,5,6,7,8,9).getDeterminant());
        InvertableMatrix A = new InvertableMatrix(3,0,2,3,4,5,6,7,8,9), B;
        B = A.invert();
        for(int iterator = 0; iterator < B.length(); iterator++){
            System.out.println(B.get(iterator));
        }
    }
}