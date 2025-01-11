package esami.DA_ANALIZZARE.B.core;


public class Camion extends Macchina {

    private float lunghezzaRimorchio;
    private float pesoCarico;
    private int limiteVelocita;

    public Camion(String colore, int matricola, String targa, int nMarce, float lunghezzaRimorchio, float pesoCarico, int limiteVelocita) {
        super("Camion", 6, 5000, colore, matricola, targa, nMarce);
        this.lunghezzaRimorchio=lunghezzaRimorchio;
        this.pesoCarico=pesoCarico;
        this.limiteVelocita=limiteVelocita;
    }

    public void caricaRimorchio(float peso){
        this.pesoCarico+=peso;
    }

    public void scaricaRimorchio(){
        this.pesoCarico=0;
    }

    public float getLunghezzaRimorchio() {
        return lunghezzaRimorchio;
    }

    public void setLunghezzaRimorchio(float lunghezzaRimorchio) {
        this.lunghezzaRimorchio = lunghezzaRimorchio;
    }

    public float getPesoCarico() {
        return pesoCarico;
    }

    public void setPesoCarico(float pesoCarico) {
        this.pesoCarico = pesoCarico;
    }

    public int getLimiteVelocita() {
        return limiteVelocita;
    }

    public void setLimiteVelocita(int limiteVelocita) {
        this.limiteVelocita = limiteVelocita;
    }

    @Override
    public String toString(){
        return "Camion[colore: "+getColore()+", matricola: "+getMatricola()+", targa: "+getTarga()+", nMarce: "
                +getnMarce()+", lunghezza: "+lunghezzaRimorchio+", peso: "+pesoCarico+", limite: "+limiteVelocita+"]";
    }
}
