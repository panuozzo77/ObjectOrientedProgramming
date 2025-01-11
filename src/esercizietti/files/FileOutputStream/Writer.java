package esercizietti.files.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("binaryfile.ser");
            for (int i = 0; i < 10; i++) {
                fos.write(i); //possiamo scrivere solo ed esclusivamente tipi base come gli interi
                fos.write("fine!".getBytes()); //le stringhe vanno trasformate, così come qualsiasi altro dato "più concreto"
            }
            fos.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
