package esercizietti.files.SerializedClass;

import java.io.Serializable;

public class MyClass implements Serializable {
    String name;
    String surname;

    public MyClass(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "MyClass [name=" + name + ", surname=" + surname + "]";
    }
}
