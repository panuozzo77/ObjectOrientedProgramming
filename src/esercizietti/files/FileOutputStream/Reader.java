package esercizietti.files.FileOutputStream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("binaryfile.ser");
            int b = 0;
            while ((b = fis.read()) != -1) { // Legge un byte alla volta
                System.out.println((char) b); // Stampa i dati letti
            }
            fis.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
