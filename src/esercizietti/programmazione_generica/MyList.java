package esercizietti.programmazione_generica;

/*
Esercizio: Creare una Classe Generica per una Lista

Scrivi una classe generica MyList<T> che simuli il comportamento di una lista (simile a ArrayList).
La classe deve includere i seguenti metodi:

    Aggiungere un elemento: Un metodo add(T element) per aggiungere un elemento alla lista.
    Ottenere un elemento: Un metodo get(int index) per ottenere l'elemento in una determinata posizione.
    Rimuovere un elemento: Un metodo remove(int index) per rimuovere l'elemento in una determinata posizione.
    Dimensione: Un metodo size() per ottenere il numero di elementi nella lista.

La classe deve usare un array interno per memorizzare gli elementi e ridimensionare
automaticamente l'array quando necessario.
*/

public class MyList <T> {
    private T[] list;
    private int elementsInside = 0;
    private int maxSize = 0;

    public MyList (int n) {
        list = (T[]) new Object[n];
        maxSize = n;
        for (int i = 0; i < n; i++) {
            list[i] = null;
        }
    }

    public void add(T element) {
        if (elementsInside >= maxSize) {
            throw new IndexOutOfBoundsException();
        }
        this.list[elementsInside] = element;
        elementsInside++;
    }

    public T get(int index) {
        if (index < 0 || index >= elementsInside) {
            throw new IndexOutOfBoundsException();
        }
        return index < elementsInside ? this.list[index] : null;
    }

    public void remove(int index) {
        if (index < 0 || index >= elementsInside) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < elementsInside - 1; i++) {
            list[i] = list[i + 1];
        }
        list[--elementsInside] = null;
    }

    public int size() {
       return elementsInside;
    }
}
