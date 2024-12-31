package esercizietti.lambda_stream;

import java.util.Arrays;
import java.util.List;

/*
Scrivi un programma che:

    Dato un elenco di stringhe, conta quante parole contengono una lettera specifica utilizzando una funzione lambda.
    Stampa il conteggio.
 */
public class Main4 {
    public static void main(String[] args) {
        List<String> parole = Arrays.asList("mela", "banana", "albicocca", "ananas", "mirtillo");
        String iniziale = "a";

        long counter = parole.stream()
                .filter(parola -> parola.contains(iniziale))
                .count();

        System.out.println("Sono state trovate "+ counter + " parole che contengono la lettera: " + iniziale);
    }
}
