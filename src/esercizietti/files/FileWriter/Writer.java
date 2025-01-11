package esercizietti.files.FileWriter;

import esercizietti.files.SerializedClass.MyClass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MyClass("name"+i, "surname"+i));
        }
        try {
            FileWriter fw = new FileWriter("fileWriter.txt");
            for (MyClass m : list) {
                fw.write(m.toString()+'\n');
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
