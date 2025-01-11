package esami.DA_ANALIZZARE.A.core;

public class Cavaliere extends Personaggio{
    private static int count = 0;
    public Cavaliere(int energia, int posizioneIniziale, float rotazione){
        this.id=count++;
        this.tipo="Cavaliere";
        this.energia=energia;
        this.posizioneIniziale=posizioneAttuale;
        this.posizioneAttuale = posizioneIniziale;
        this.rotazione=rotazione;
    }
}
