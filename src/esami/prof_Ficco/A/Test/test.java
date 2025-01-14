package esami.prof_Ficco.A.Test;

import esami.prof_Ficco.A.core.Gestore;
import esami.prof_Ficco.A.core.Personaggio;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class test {
    public static void main(String[] args){
        Gestore g = new Gestore(50);
        printOrco(g);
        System.out.println(printCavalieri(g));
        printCavalieri2(g);
    }

    public static void printOrco(Gestore g){
        Predicate<Personaggio> filter = p -> g.getType(p).equalsIgnoreCase("orco");
        Consumer<Personaggio> block = p -> System.out.println(p.getId());
        g.getPersonaggi().stream().filter(filter).forEach(block);
    }

    public static int printCavalieri(Gestore g){
        Predicate<Personaggio> filter = p -> g.getType(p).equalsIgnoreCase("Cavaliere") && p.getEnergia()>50 && g.getPos(p)<50 ;
        return (int) g.getPersonaggi().stream().filter(filter).count();
    }

    public static void printCavalieri2(Gestore g){
        Predicate<Personaggio> filter = p -> g.getType(p).equalsIgnoreCase("Cavaliere") && p.getEnergia()>70 ;
        Consumer<Personaggio> block = p -> System.out.println(p.getId());
        g.getPersonaggi().stream().filter(filter).forEach(block);
    }


}
