package ru.omsu.imit.matrixTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.omsu.imit.matrices.*;

import static org.testng.Assert.*;

public class MatrixTest {
    @DataProvider
    public Object[][]goodRes(){
        return new Object[][]{
                {3,0.0,1,2,3,4,5,6,7,8,9},
                {3,3,0,2,3,4,5,6,7,8,9},
                {3,-21,0,2,3,0,5,6,7,8,9},
                {3, 204, 1,-2,3,4,0,6,-7,8,9},
                {2, -67, 11,-3,-15,-2},
                {4, 6008, 0,1,-4,9,8,0,5,5,-2,11,0,-7,8,-9,1,0},
                {3, 0, 2,0,4,6,0,8,10,0,12},
                {5, 50, 0,3,-1,2,6,2,1,0,0,3,-2,-1,0,2,5,-5,7,1,1,1,2,0,2,-2,1},
                {3, 42, 2,-1,4,1,0.7,-5,0,3,0},
                {5, 11, 1,2,4,3,5,5,3,2,1,1,1,3,2,1,4,4,2,2,1,1,1,1,3,2,2},
                {1, 5, 5}
        };
    }@DataProvider
    public static Object[][] invertible() {
        return new Object[][] {
                {3, 2,5,7,6,3,4,5,-2,-3},
                {3, -5,5,8,1,-4,-4,-2,6,6},
                {3, 1,2,3,3,3,2,1,4,1},
                {2, 1,2,3,4},
                {2, 1,2,2,3},
                {4, 9,-3,-7,4,-2,0,5,0,-6,3,1,-8,-1,9,-5,2},
                {3, -1,7,-6,4,9,-3,-8,-2,-5},
                {5, 4,4,5,3,4, 9,2,5,2,3, 0,6,2,4,8, 3,0,0,3,2, 9,2,0,1,6}
        };
    }

    @DataProvider
    public static Object[][] invertibleExcept() {
        return new Object[][] {
                {3, 1,2,3,4,5,6,7,8,9},
                {4, 1,4,0,5,7,-9,0,1,4,4,0,7,-8,1,0,1}
        };
    }

    @Test(dataProvider = "goodRes")
    public void testGetDeterminant(int size, double wanted, double...arr) throws Exception {
        assertTrue(Math.abs(new Matrix(size, arr).getDeterminant() - wanted) <= 1e-9);
    }


    @Test(dataProvider = "invertible")
    public void invertibleTest(int size, double...arr) throws MatrixException {
        Matrix blossom = new Matrix(size, arr);
        InvertableMatrix im = new InvertableMatrix(blossom);
        assertTrue(blossom.multiply(im.invert()).isIdentity());
    }

    @Test(dataProvider = "invertibleExcept", expectedExceptions = MatrixIsntInvertableException.class)
    public void invertibleFail(int size, double...arr) {
        InvertableMatrix im = new InvertableMatrix(size, arr);
        fail();
    }

}