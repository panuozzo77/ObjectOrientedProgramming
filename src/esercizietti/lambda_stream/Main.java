package esercizietti.lambda_stream;

import java.util.Arrays;
import java.util.List;

/*
Crea un programma che:

    Dato un elenco di numeri interi, filtra solo i numeri pari utilizzando l'API Stream e una funzione lambda.

    Stampa i numeri filtrati.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numeri.stream()
                .filter( n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
