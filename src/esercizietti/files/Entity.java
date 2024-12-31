package esercizietti.files;

import java.io.Serializable;

public class Entity implements Serializable {
    private String name;
    private String surname;
    private int age;

    Entity(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Entity [name=" + name + ", surname=" + surname + ", age=" + age +"]";
    }
}
