package AgenziaImmobiliare;

public class Commerciale extends Immobile {
    private int m2;
    private boolean isHighlyPolluting;

    //variabile usata per salvare costi delle tasse
    private float TARI;

    //public Immobile(String nome, String nomeC, String indirizzo, boolean commercial) {
    public Commerciale(String nome, String nomeC, String indirizzo, boolean commerciale, int m2, boolean isPolluting){
        super(nome, nomeC, indirizzo, commerciale);
        this.m2 = m2;
        this.isHighlyPolluting = isPolluting;
    }

    public void calcolaTasse(){
        float perMetro = m2 * 28;
        TARI = isHighlyPolluting ? 80 + perMetro : 40 + perMetro;
    }

    public void libera(){
        super.libera();
    }

    public void affitta(){
        super.affitta();
    };

    @Override
    public String toString() {
        return "Commerciale{" +
                "m2=" + m2 +
                ", isHighlyPolluting=" + isHighlyPolluting +
                ", TARI=" + TARI +
                ", details=" + super.toString() +
                '}';
    }
}
