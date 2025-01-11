package esami.Conferenze;

import esercizietti.lambda_stream.Persona;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Studente extends Registrazione implements Serializable {
    private String nomeUniversita;
    private String Tipologia;


    public Studente(String nome, String cognome, int giorno, int mese, int anno, String nomeUniversita, String Tipologia) throws BadDateException {
        super(nome, cognome, giorno, mese, anno);
        this.nomeUniversita = nomeUniversita;
        this.Tipologia = Tipologia;
    }

    public boolean isInRitardo(){
        GregorianCalendar d = super.getData();
        if(d.after(new GregorianCalendar(2020, 01, 31))) {
            return true;
        }
        return false;
    }

    public int calcolaCosto(){
        GregorianCalendar d = super.getData();
        if(d.before(new GregorianCalendar(2020, 01, 31))) {
            return 250;
        }
        else return 300;
    }

    public boolean isStudente() {
        return true;
    }

    public String getTipologia() {
        return Tipologia;
    }

    public void setTipologia(String tipologia) {
        Tipologia = tipologia;
    }

    public String getNomeUniversita() {
        return nomeUniversita;
    }

    public void setNomeUniversita(String nomeUniversita) {
        this.nomeUniversita = nomeUniversita;
    }

    @Override
    public String toString() {
        return "[Studente: "+nomeUniversita+" Tipologia "+Tipologia+ "] " +super.toString();
    }
}
