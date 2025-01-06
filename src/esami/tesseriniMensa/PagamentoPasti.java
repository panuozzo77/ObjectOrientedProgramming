package esami.tesseriniMensa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PagamentoPasti {
    private ArrayList<Tesserino> list = new ArrayList<>();
    private double ammontare = 0;

    public void add(Tesserino t) {
        list.add(t);
    }

    public boolean usaTesserino(int code) {
        for (Tesserino t : list) {
            if (t.getCodice() == code) {
                ammontare += t.paga();
                return true;
            }
        }
        return false;
    }

    public double calcolaTotale() {
        return ammontare;
    }

    @Override
    public String toString() {
        String toReturn = "somma: " + ammontare + "\n";
        for (Tesserino t : list) {
            toReturn += t.toString() + "\n";
        }
        return toReturn;
    }

    public void initialize() {
        TesserinoPersonale tp = new TesserinoPersonale("Sofia", "Ganeri", true, "Informatica", "docente");
        TesserinoStudente ts1 = new TesserinoStudente("Cristian", "Porzio", true, "0512100000", "31/12/2026", "A", false);
        TesserinoStudente ts2 = new TesserinoStudente("Raffaele", "Monti", true, "0512100001", "31/12/2026", "B", true);
        list.add(tp);
        list.add(ts1);
        list.add(ts2);
        ts1.versa(20);
        ts2.versa(10);
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            list = (ArrayList<Tesserino>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
