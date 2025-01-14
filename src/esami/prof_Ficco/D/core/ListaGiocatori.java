package esami.prof_Ficco.D.core;

import esami.prof_Ficco.D.eccezioni.GiocatoreException;
import esami.prof_Ficco.D.interfacce.SquadraDiCalcio;

import java.util.ArrayList;
import java.util.List;

public abstract class ListaGiocatori implements SquadraDiCalcio {
    protected int codiceSquadra;
    protected String nomeSquadra;
    protected int annoCampionato;
    protected int maxGiocatori;

    protected List<Giocatore> giocatori;

    protected int aggiuntaCount = 0;

    private static int i = 0;

    public ListaGiocatori(String nome, int anno, int maxG){
        this.codiceSquadra = i++;
        this.nomeSquadra = nome;
        this.annoCampionato = anno;
        this.maxGiocatori = maxG;
        this.giocatori = new ArrayList<Giocatore>();
    }

   public void Modifica(int i) {
       maxGiocatori = i;
   }

    public int getCodiceSquadra() {
        return codiceSquadra;
    }

    public void setCodiceSquadra(int codiceSquadra) {
        this.codiceSquadra = codiceSquadra;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public void setNomeSquadra(String nomeSquadra) {
        this.nomeSquadra = nomeSquadra;
    }

    public int getAnnoCampionato() {
        return annoCampionato;
    }

    public void setAnnoCampionato(int annoCampionato) {
        this.annoCampionato = annoCampionato;
    }

    public int getMaxGiocatori() {
        return maxGiocatori;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

    public abstract void Aggiungi(Giocatore g) throws GiocatoreException;

    public abstract void Rimuovi(Giocatore g) throws GiocatoreException;
}
