package esercizietti.files.ObjectOutputStream;

import esercizietti.files.SerializedClass.MyClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Writer {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        //random.nextInt(2);
        ArrayList<MyClass> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MyClass("name"+i, "surname"+i));
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myClass.ser"));
        for(MyClass mc : list) {
            oos.writeObject(mc);
        }
    }
}
