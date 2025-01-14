package esami.prof_Ficco.D.core;

public class Giocatore {

    private static int i = 0;
    private int cartellino;
    private String nome;
    private int eta;
    private float stipendio;

    public Giocatore(String n, int e, float s){
        this.cartellino = i++;
        this.nome = n;
        this.eta = e;
        this.stipendio = s;
    }

    public int getCartellino() {
        return cartellino;
    }

    public void setCartellino(int cartellino) {
        this.cartellino = cartellino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public float getStipendio() {
        return stipendio;
    }

    public void setStipendio(float stipendio) {
        this.stipendio = stipendio;
    }
}
