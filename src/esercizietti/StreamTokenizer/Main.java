package esercizietti.StreamTokenizer;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        int numeroParole = 0, numeroNumeri = 0;

        try {
            // Inizializza StreamTokenizer per leggere dal file
            //StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader("Lista.txt")));

            // Leggi i token dal file
            while (true) {
                st.nextToken();

                if (st.ttype == StreamTokenizer.TT_WORD) { // Se il token è una parola
                    System.out.println("Parola trovata: " + st.sval);
                    numeroParole++;
                } else if (st.ttype == StreamTokenizer.TT_NUMBER) { // Se il token è un numero
                    System.out.println("Numero trovato: " + st.nval);
                    numeroNumeri++;
                } else if (st.ttype == StreamTokenizer.TT_EOF) { // Fine del file
                    break;
                }
            }

            // Stampa il risultato
            System.out.println("Parole trovate: " + numeroParole);
            System.out.println("Numeri trovati: " + numeroNumeri);

        } catch (FileNotFoundException e) {
            System.out.println("Errore: Il file Lista.txt non esiste.");
        } catch (IOException e) {
            System.out.println("Errore di I/O: " + e.getMessage());
        }
    }
}
