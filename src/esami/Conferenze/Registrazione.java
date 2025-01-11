package esami.Conferenze;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Registrazione implements Serializable {
    private String nome;
    private String cognome;
    private GregorianCalendar data;

    public Registrazione(String nome, String cognome, int giorno, int mese, int anno) throws BadDateException {
        this.nome = nome;
        this.cognome = cognome;
        this.data = new GregorianCalendar(anno, mese, giorno);
        check(data);
    }

    private void check(GregorianCalendar d) throws BadDateException {
        if (d.after(new GregorianCalendar(2020, 04, 30))) {
            throw new BadDateException("Data superiore al 30 04 2020");
        }

    }
    public abstract boolean isInRitardo();

    public abstract int calcolaCosto();

    public abstract boolean isStudente();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String year = String.valueOf(data.get(GregorianCalendar.YEAR));
        String month = String.valueOf(data.get(GregorianCalendar.MONTH));
        String day = String.valueOf(data.get(GregorianCalendar.DAY_OF_MONTH));
        String data2 = day + "/" + month + "/" + year;
        return "Registrazione [nome=" + nome + ", cognome="+ cognome + ", data=" + data2 + "]";
    }
}
