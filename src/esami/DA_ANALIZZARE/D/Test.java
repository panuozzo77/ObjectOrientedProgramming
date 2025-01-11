package esami.DA_ANALIZZARE.D;

import esami.DA_ANALIZZARE.D.core.Giocatore;
import esami.DA_ANALIZZARE.D.core.Squadra;
import esami.DA_ANALIZZARE.D.eccezioni.GiocatoreException;
import esami.DA_ANALIZZARE.D.gui.gui;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        Squadra s = new Squadra("Napoli", 2000, 10);

        Giocatore g1 = new Giocatore("Marco", 15, 1000);
        Giocatore g2 = new Giocatore("Paolo", 26, 2000);
        Giocatore g3 = new Giocatore("Aldo", 22, 15000);

        try {
            s.Aggiungi(g1);
            s.Aggiungi(g2);
            s.Aggiungi(g3);
        }catch(GiocatoreException e){
            System.err.println(e.getMessage());
        }

        gui javagui = new gui(s);

        // javagui.setVisible(true);

        try(PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("Giocatori.txt")))){
            for(Giocatore g : s.getGiocatori()){
                p.println(g.toString());
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }

        printLambda(s);
        System.out.println(streamApi(s));
        tokenizer(s);
    }

    public static void printLambda(Squadra s){
        Consumer<Giocatore> c = g -> System.out.println(g.getCartellino());
        for (Giocatore g : s.getGiocatori()){
            c.accept(g);
        }
    }

    public static int streamApi(Squadra s){
        Predicate<Giocatore> filter = g -> g.getEta()>24 && g.getStipendio()>100000;
        return (int) s.getGiocatori().stream().filter(filter).count();
    }

    public static void tokenizer(Squadra s){
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        try{
            System.out.println("Inserisci nome");
            st.nextToken();
            String n = st.sval;
            System.out.println(n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
