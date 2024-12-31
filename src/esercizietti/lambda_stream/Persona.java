package esercizietti.lambda_stream;

public class Persona {
    private int age;
    private String name;

    public Persona(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compare(Persona p2) {
        return this.age - p2.getAge();
    }

    @Override
    public String toString() {
        return "Persona [age=" + age + ", name=" + name + "]";
    }
}
