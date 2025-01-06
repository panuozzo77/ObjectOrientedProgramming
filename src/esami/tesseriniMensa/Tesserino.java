package esami.tesseriniMensa;

import java.io.Serializable;

public class Tesserino implements Serializable {
    static int counter = 0;
    private int codice;
    private String nome;
    private String cognome;
    private boolean attivo;

    public Tesserino(String nome, String cognome, boolean attivo) {
        this.codice = counter;
        this.nome = nome;
        this.cognome = cognome;
        this.attivo = attivo;
        counter++;
    }

    public void attiva() {
        this.attivo = true;
    }

    public void disattiva() {
        this.attivo = false;
    }

    public boolean isActive(){
        return this.attivo;
    }

    public int getCodice() {
        return codice;
    }

    public double paga() {
        System.out.println("["+this.codice+"] sta pagando");
        return 0;
    }

    public String baseInformations() {
        return "[codice: "+this.codice+"] [nome: "+this.nome+"] [cognome: "+this.cognome+"] [attivo: "+this.attivo+"]";
    }
}
