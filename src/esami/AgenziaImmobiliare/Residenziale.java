package esami.AgenziaImmobiliare;

public class Residenziale extends Immobile {
    private int vani;
    private int residenti;
    private int piano;

    //variabili usate per salvare costi delle tasse
    private float TARI;
    private float TASI;
    private float condominiali;
    private float affitto;

    //public Immobile(String nome, String nomeC, String indirizzo, boolean commercial) {
    public Residenziale(String nome, String nomeC, String indirizzo, boolean commerciale, int vani, int residenti, int piano) throws ResidentialException {
        super(nome, nomeC, indirizzo, commerciale);
        this.vani = vani;
        this.residenti = residenti;
        this.piano = piano;
        checkResidenti();
        calcolaAffitto();
        calcolaTasse();
    }

    private void checkResidenti() throws ResidentialException{
        if(residenti>=vani*3){
            throw new ResidentialException("Il numero di residenti supera di 3 volte il numero di vani del locale!");
        }
    }
    public float calcolaAffitto(){
        return affitto = 150*vani;
    }

    public void calcolaTasse(){
        this.TARI = 110*vani;
        this.TASI = 30*residenti;
        this.condominiali = piano == 1 ? 10*vani : 15*vani;
        System.out.println("TARI: "+TARI+" TASI: "+TASI+" Condominiali: "+condominiali);
    }

    public void libera(){
        this.residenti = 0;
        super.libera();
    }

    public int getResidenti(){
        return residenti;
    }

    public void affitta(int residenti) throws ResidentialException{
        checkResidenti();
        this.residenti = residenti;
        super.affitta();
    };

    @Override
    public String toString() {
        return "Residenziale{" +
                "vani=" + vani +
                ", residenti=" + residenti +
                ", piano=" + piano +
                ", TARI=" + TARI +
                ", TASI=" + TASI +
                ", condominiali=" + condominiali +
                ", affitto=" + affitto +
                ", details=" + super.toString() +
                '}';
    }

}
