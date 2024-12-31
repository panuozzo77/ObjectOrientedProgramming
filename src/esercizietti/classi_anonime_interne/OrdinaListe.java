package esercizietti.classi_anonime_interne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdinaListe {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Roma");
        list.add("Milano");
        list.add("Napoli");
        list.add("Torino");

        Comparator comp = new Comparator() {
            @Override
            public void compare(ArrayList<String> list) {
                Collections.sort(list, Collections.reverseOrder());
            }
        };

        //comp.compare(list);
        //System.out.println(list);

        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));

        System.out.println(list);
    }
}
