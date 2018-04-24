package ru.omsu.imit.matrices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DemoMatrix {
    public static void toStream(String file, Matrix matrix) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))){
            writer.write(matrix.length() + "\r\n");
            for(int i = 0; i < matrix.length(); i++){
                for(int j = 0; j < matrix.length())
            }
        }
    }
}
