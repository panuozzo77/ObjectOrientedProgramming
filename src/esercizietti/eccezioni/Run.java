package esercizietti.eccezioni;

import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        Dispositivo uno = new Dispositivo("lampadina", "accesa lampadina");
        Dispositivo due = new Dispositivo("aria condizionata", "aria condizionata fredda", false);
        Dispositivo tre = new Dispositivo("termosifoni", "temperatura a 60 gradi");
        ArrayList<Dispositivo> list = new ArrayList<Dispositivo>();
        list.add(uno);
        list.add(due);
        list.add(tre);

        CasaIoT casa = new CasaIoT(list);
        casa.usaTutto();
        System.out.println("\n facciamo spazio \n");
        casa.accendiTutto();
        casa.usaTutto();
    }
}
