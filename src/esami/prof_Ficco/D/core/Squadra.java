package esami.prof_Ficco.D.core;

import esami.prof_Ficco.D.eccezioni.GiocatoreException;

public class Squadra  extends ListaGiocatori{
    public Squadra(String nome, int anno, int maxG) {
        super(nome, anno, maxG);
    }

    @Override
    public void Aggiungi(Giocatore g) throws GiocatoreException {
        if(!super.getGiocatori().contains(g) && super.getMaxGiocatori() > super.getGiocatori().size()+1){
            super.getGiocatori().add(g);
            super.aggiuntaCount++;
        }else{
            throw new GiocatoreException("Giocatore già presente!");
        }
    }

    @Override
    public void Rimuovi(Giocatore g) throws GiocatoreException {
        if(super.getGiocatori().contains(g)){
            super.getGiocatori().remove(g);
        }else{
            throw new GiocatoreException("Giocatore non presente!");
        }
    }

    @Override
    public void Modifica(int i){
        if(i>0 && super.getGiocatori().size() < i){
            super.maxGiocatori = i;
        }
    }
}
