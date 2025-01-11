package esami.Conferenze;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Writer {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Registrazione> list = new ArrayList<>();
        int choice, giorno, mese, anno, tipologia, i=0;
        while(list.size() < 20){
            choice = rand.nextInt(2);
            giorno = rand.nextInt(30) +1;
            mese = rand.nextInt(12) + 1;
            anno = rand.nextInt(25) + 2000;
            if(choice == 0) {
                //Studente(String nome, String cognome, int giorno, int mese, int anno, String nomeUniversita, String Tipologia)
                String type = "";
                tipologia = rand.nextInt(3);
                if(tipologia == 0) {
                    type = "Triennale";
                }
                if(tipologia == 1) {
                    type = "Magistrale";
                }
                if(tipologia == 2) {
                    type = "Dottorato";
                }
                try {
                    Studente st = new Studente("nome" + i, "cognome" + i, giorno, mese, anno, "Salerno", type);
                    list.add(st);
                } catch (BadDateException e) {
                    e.printStackTrace();
                }

            }
            else {
                //Professionista(String nome, String cognome, int giorno, int mese, int anno, String nomeAzienda, String pIVA)
                String IVA = "IT";
                for(int j = 0; j < 10; j++){
                    IVA = IVA.concat(String.valueOf(rand.nextInt(9)));
                }
                try{
                    Professionista p = new Professionista("nome" + i, "cognome" + i, giorno, mese, anno, "Azienda"+i, IVA);
                    list.add(p);
                } catch(BadDateException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("conferenze.ser"));

            for(Registrazione r : list) {
                System.out.println(r);
                oos.writeObject(r);
            }
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
