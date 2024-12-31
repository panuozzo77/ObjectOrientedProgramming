package esercizietti.programmazione_generica;

public class Run {

    public static void main(String[] args) {
        MyList<String> list = new MyList<String>(5);
        System.out.println(list.size());
        list.add("A");
        list.add("B");
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());
        String test = list.get(0);
        System.out.println("Cosa conteneva l'array in 0: " + test);
    }
}
