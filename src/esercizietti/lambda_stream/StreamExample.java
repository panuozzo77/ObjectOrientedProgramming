package esercizietti.lambda_stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> square = null;

        // Pipeline di metodi
        List<Integer> count = numbers.stream()
                .filter(n -> n % 2 == 0) // Intermedio: Filtra i numeri pari
                .map(x -> x*x)          // Intermedio: Eleva al quadrato i numeri
                .collect(Collectors.toList()); // Terminale: Raccoglie i risultati in una lista
                //.count();                // Terminale: Conta gli elementi

        System.out.println("Numeri pari al quadrato: " + count);
        System.out.println(count);
    }
}