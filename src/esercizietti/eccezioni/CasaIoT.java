package esercizietti.eccezioni;

import java.util.ArrayList;

public class CasaIoT {
    ArrayList<Dispositivo> list = new ArrayList<>();

    public CasaIoT(ArrayList<Dispositivo> list) {
        this.list = list;
    }

    public void accendiTutto() {
        list.forEach(t -> t.setDisponibile(true));
    }

    public void usaTutto() {
        list.forEach(t -> {
            try {
                t.utilizza();
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
