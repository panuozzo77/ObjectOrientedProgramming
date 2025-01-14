package esami.prof_Ficco.B.test;

import esami.prof_Ficco.B.GUI.gui;
import esami.prof_Ficco.B.core.Autovettura;
import esami.prof_Ficco.B.core.Camion;
import esami.prof_Ficco.B.core.Macchina;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) throws IOException {
        List<Autovettura> lista = new ArrayList<>();

        Macchina m1 = new Macchina("sportiva", 4, 2000, "Rossa", 4185, "RH435TT", 5);
        Macchina m2 = new Macchina("SUV", 4, 3000, "Bianco", 5919, "CH425Ty", 7);
        Camion c1 = new Camion("Giallo", 2176, "PP276QR", 9, 370f, 250f, 100);
        Camion c2 = new Camion("Blu", 52198, "PO176DA", 9, 360f, 4f, 110);

        lista.add(m1);
        lista.add(m2);
        lista.add(c1);
        lista.add(c2);
        try (PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("Autovetture.txt")))){
            for(Autovettura a : lista) {
                p.println(a);
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
            throw e;
        }

        gui g = new gui(lista);
        // g.setVisible(true);

        stampa(lista);
        stream(lista);

    }

    public static void stampa(List<Autovettura> l){
        Predicate<Autovettura> p = a -> a instanceof Camion;
        Consumer<Camion> b = System.out::println;
        for(Autovettura a: l){
            if(p.test(a)){
                b.accept((Camion) a);
            }
        }
    }

    public static void stream(List<Autovettura> l){
        Predicate<Autovettura> filter = a -> a instanceof Camion && ((Camion)a).getPesoCarico() > 5 && ((Camion)a).getLimiteVelocita()>80;
        Predicate<Autovettura> filter2 = a -> a instanceof Macchina && ((Macchina) a).getnMarce() >6;
        Consumer<Autovettura> block = a -> {
          Macchina b = (Macchina)a;
          System.out.println("Matricole: "+ b.getMatricola());
        };
        System.out.println("Numero di camion: " + (int) l.stream().filter(filter).count());
        l.stream().filter(filter2).forEach(block);

    }

}
