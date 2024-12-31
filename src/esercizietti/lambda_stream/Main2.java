package esercizietti.lambda_stream;

import java.util.Arrays;
import java.util.List;

/*
Crea una classe Persona con i seguenti campi:

    String nome
    int età

Scrivi un programma che:

    Crea una lista di oggetti Persona.
    Ordina la lista in base all'età in ordine crescente utilizzando una funzione lambda.
    Stampa la lista ordinata.
 */
public class Main2 {
    public static void main(String[] args) {
        List<Persona> persone = Arrays.asList(
                new Persona("Mario", 30),
                new Persona("Luca", 25),
                new Persona("Anna", 35));

        persone.stream()
                .sorted( (p1, p2) -> p1.compare(p2))
                .forEach(System.out::println);
    }
}
