package esami.Conferenze;

import esercizietti.lambda_stream.Persona;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Set;

public class Professionista extends Registrazione implements Serializable {
    private String nomeAzienda;
    private String pIVA;

    public Professionista(String nome, String cognome, int giorno, int mese, int anno, String nomeAzienda, String pIVA) throws BadDateException {
        super(nome, cognome, giorno, mese, anno);
        this.nomeAzienda = nomeAzienda;
        this.pIVA = pIVA;
    }

    public boolean isInRitardo(){
        GregorianCalendar d = super.getData();
        if(d.after(new GregorianCalendar(2020, 02, 3))) {
            return true;
        }
        return false;
    }

    public int calcolaCosto(){
        GregorianCalendar d = super.getData();
        if(d.before(new GregorianCalendar(2020, 02, 3))) {
            return 500;
        }
        else return 550;
    }

    public boolean isStudente() {
        return false;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getpIVA() {
        return pIVA;
    }

    public void setpIVA(String pIVA) {
        this.pIVA = pIVA;
    }

    @Override
    public String toString() {
        return "[Azienda: "+nomeAzienda+" P.IVA "+pIVA+"] " +super.toString();
    }
}
