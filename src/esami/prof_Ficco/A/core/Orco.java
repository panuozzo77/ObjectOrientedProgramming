package esami.prof_Ficco.A.core;

public class Orco extends Personaggio{
    private static int count = 0;
    public Orco(int energia, int posizioneIniziale, float rotazione){
        this.id=count++;
        this.tipo="Orco";
        this.energia=energia;
        this.posizioneIniziale=posizioneAttuale;
        this.posizioneAttuale = posizioneIniziale;
        this.rotazione=rotazione;
    }
}
