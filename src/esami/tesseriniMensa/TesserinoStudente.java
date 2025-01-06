package esami.tesseriniMensa;

import java.io.Serializable;

public class TesserinoStudente extends Tesserino implements Serializable {
    private String matricola;
    private String scadenza;
    private double saldo;
    private String fascia;
    private boolean bonus;

    public TesserinoStudente(String nome, String cognome, boolean attivo, String matricola, String scadenza, String fascia, boolean bonus) {
        super(nome, cognome, attivo);
        this.matricola = matricola;
        this.scadenza = scadenza;
        this.fascia = fascia;
        this.bonus = bonus;
        this.saldo = 0;
    }

    public float calcolaPrezzo() {
        float prezzo = 2.5f;
        if(this.fascia.equals("A")) {
            prezzo = 2.5f;
        }
        if(this.fascia.equals("B")) {
            prezzo = 1.5f;
        }
        if(bonus){
            prezzo = prezzo-1.0f;
        }
        return prezzo;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public double paga() {
        float pagamento = calcolaPrezzo();
        if(!isActive()) {
            throw new TesserinoScadutoException("La tessera ["+ this.getCodice()+"] risulta scaduta! Pagamento [" + pagamento + "] rifiutato");
        }
        else if(this.saldo >= pagamento) {
                this.saldo -= pagamento;
                return pagamento;
            }
        else throw new OperazioneBloccata("\"La tessera ["+ this.getCodice()+"] non ha saldo sufficiente");
    }

    public void versa(double x) {
        if(x<=0)
            throw new RuntimeException("Saldo negativo!");
        this.saldo += x;

    }

    @Override
    public String toString() {
        return "[Tipologia: Studente] [saldo: "+saldo+"] [fascia: "+fascia+"] [bonus: "+bonus+"] "+baseInformations();
    }
}
