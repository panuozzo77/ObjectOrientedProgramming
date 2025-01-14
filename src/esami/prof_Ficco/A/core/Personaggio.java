package esami.prof_Ficco.A.core;

import esami.prof_Ficco.A.eccezioni.PlayerException;
import esami.prof_Ficco.A.interfacce.PersMaster;

public abstract class Personaggio implements PersMaster {
    protected int id;
    protected String tipo;
    protected int energia;
    protected int posizioneIniziale;
    protected int posizioneAttuale;

    protected float rotazione;

    public void Colpisci(Personaggio pers){
        pers.energia -= 1;
    }

    @Override
    public void Ruota(int g) {
        this.rotazione = (rotazione+g)%360;
    }

    @Override
    public void Avanti(int s) throws PlayerException {
        this.posizioneAttuale += s;
        if(this.posizioneAttuale > 100){
            throw new PlayerException("Superato il quadro di gioco!");
        }

    }

    @Override
    public void Indietro(int s) throws PlayerException {
        this.posizioneAttuale -= s;
        if(this.posizioneAttuale < 0){
            throw new PlayerException("Superato il quadro di gioco!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getPosizioneIniziale() {
        return posizioneIniziale;
    }

    public void setPosizioneIniziale(int posizioneIniziale) {
        this.posizioneIniziale = posizioneIniziale;
    }

    public int getPosizioneAttuale() {
        return posizioneAttuale;
    }

    public void setPosizioneAttuale(int posizioneAttuale) {
        this.posizioneAttuale = posizioneAttuale;
    }

    public float getRotazione() {
        return rotazione;
    }

    public void setRotazione(float rotazione) {
        this.rotazione = rotazione;
    }
}
