package AgenziaImmobiliare;

import java.util.ArrayList;

public class AgenziaImmobiliare {
    private String nome;
    private ArrayList<Immobile> list = new ArrayList<Immobile>();
    private int max;

    public AgenziaImmobiliare(String nome, int m){
        this.nome = nome;
        this.max = m;
    }

    public void aggiungiImmobile(Immobile i) throws NumMaxException{
        if(list.size() >=max){
            throw new NumMaxException("L'agenzia non accetta ulteriori immobili!");
        }
        this.list.add(i);
    }


    public void affitta(Immobile i) throws GiaLocatoException{
        if(i.isAvailable()){
            if(i.isForCommercialUse()){
                i.affitta();
            }
        }
        else {
            throw new GiaLocatoException();
        }
    }

    public void affitta(int npers, Immobile i) throws ResidentialException, GiaLocatoException{
        if (i.isAvailable()){
            if(!i.isForCommercialUse()){
                i.affitta(npers);
            }
            else{
                throw new ResidentialException("Questo locale non è Residenziale");
            }

        }
        else {
            throw new GiaLocatoException();
        }
    }

    public void libera(Immobile i){
        list.get(list.indexOf(i)).libera();
    }



}
