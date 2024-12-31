package esercizietti.lambda_stream;

/*
Scrivi un programma che:

    Implementa le operazioni di somma, sottrazione, moltiplicazione e divisione usando espressioni lambda.
    Esegue ciascuna operazione con i numeri 8 e 4 e stampa il risultato.
 */

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        Operazione somma = (x, y) -> x + y;
        Operazione sottrazione = (x, y) -> x - y;
        Operazione moltiplicazione = (x, y) -> x * y;
        Operazione divisione = (x, y) -> x / y;

        ArrayList<Double> risultati = new ArrayList<>();

        risultati.add(somma.calcola(2, 2));
        risultati.add(sottrazione.calcola(5, 2));
        risultati.add(moltiplicazione.calcola(6, 7));
        risultati.add(divisione.calcola(7, 2));

        risultati.stream().forEach(System.out::println);
    }

}
