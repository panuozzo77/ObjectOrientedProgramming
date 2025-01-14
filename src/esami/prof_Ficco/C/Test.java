package esami.prof_Ficco.C;

import esami.prof_Ficco.C.core.ListaPacchiNatale;
import esami.prof_Ficco.C.core.Pacco;

import javax.management.InvalidAttributeValueException;
import java.io.*;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args){
        ListaPacchiNatale l = new ListaPacchiNatale(Date.valueOf("2024-03-16"), Date.valueOf("2024-12-25"));
        try{
            Pacco p1 = new Pacco("Palla", "Grande", Date.valueOf("2024-12-16"));
            Pacco p2 = new Pacco("Giocattolo", "Medio", Date.valueOf("2024-12-15"));
            Pacco p3 = new Pacco("Trottola", "Piccolo", Date.valueOf("2024-12-17"));

            l.Aggiungi(p1);
            l.Aggiungi(p2);
            l.Aggiungi(p3);

            stampaLista(l);

            //GUI g = new GUI(l);

        }catch (InvalidAttributeValueException e){
            System.err.println(e.getMessage());
        }

        ordina(l);
        stampaGrandi(l);

    }

    public static void stampaLista(ListaPacchiNatale l){
        try(PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("Lista.txt")));){
            for (Pacco pacco : l.getLista()){
                System.out.println("Pacco "+ pacco);
                p.println(pacco.toString());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void ordina(ListaPacchiNatale l){
        Comparator<Pacco> c = (p1, p2) -> Math.toIntExact(p1.getDataArrivo().getTime() - p2.getDataArrivo().getTime());
        l.getLista().sort(c);
        Collections.reverse(l.getLista());

        for(Pacco p : l.getLista()){
            System.out.println("Ordinati:"+ p);
        }
    }

    public static void stampaGrandi(ListaPacchiNatale l){
        Predicate<Pacco> filter = p -> p.getTipologia().equalsIgnoreCase("Grande");
        Consumer<Pacco> block = System.out::println;
        l.getLista().stream().filter(filter).forEach(block);


    }

}
