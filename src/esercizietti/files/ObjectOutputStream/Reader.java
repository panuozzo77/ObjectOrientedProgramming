package esercizietti.files.ObjectOutputStream;

import esercizietti.files.SerializedClass.MyClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Reader {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<MyClass> list = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myClass.ser"))) {
            while (true) {
                try {
                    MyClass read = (MyClass) ois.readObject();
                    list.add(read);
                } catch (IOException e) {
                    // Interrompi il ciclo alla fine del file
                    if (e instanceof java.io.EOFException) {
                        break;
                    } else {
                        throw e; // Rilancia altre eccezioni di I/O
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int counter = 0;
        for(MyClass c : list){
            System.out.println("["+counter+"]: "+c);
            counter++;
        }


    }
}
