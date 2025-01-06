package esami.tesseriniMensa;

import java.io.Serializable;

public class TesserinoPersonale extends Tesserino implements Serializable  {
    private String facolta;
    private double sommaSpesa = 0;
    private String categoria;

    public TesserinoPersonale(String nome, String cognome, boolean attivo, String facolta, String categoria) {
        super(nome, cognome, attivo);
        this.facolta = facolta;
        this.categoria = categoria;
    }

    @Override
    public double paga(){
        double paga = 0;
        if(categoria.contains("docente")){
            paga = 1.6;
        }
        if(categoria.contains("amministrativo")){
            paga = 4;
        }
        sommaSpesa += paga;
        return paga;
    }

    public void cambiaCategoria(){
        if(categoria.contains("docente")){
            this.categoria = "amministrativo";
        }
        if(categoria.contains("docente")){
            this.categoria = "docente";
        }
    }

    @Override
    public String toString() {
        return "[Tipologia: Amministrazione] [spesa: "+sommaSpesa+"] [facolta: "+facolta+"] [categoria: "+categoria+"] "+baseInformations();
    }

}
