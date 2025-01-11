package esami.AgenziaImmobiliare;

import java.util.ArrayList;

public class AgenziaImmobiliare {
    private String nome;
    private ArrayList<Immobile> list = new ArrayList<Immobile>();
    private int max;


    public AgenziaImmobiliare(ArrayList<Immobile> list) {
        this.list = list;
        this.max = 25;
    }

    public AgenziaImmobiliare(String nome, int m){
        this.nome = nome;
        this.max = m;
    }

    public ArrayList<Immobile> getImmobiliNonLocati(){
        ArrayList<Immobile> result = new ArrayList<Immobile>();
        list.stream()
                .filter(Immobile::isAvailable)
                .forEach(result::add);
        return result;
    }


    public void aggiungiImmobile(Immobile i) throws NumMaxException{
        if(list.size() >=max){
            throw new NumMaxException("L'agenzia non accetta ulteriori immobili!");
        }
        this.list.add(i);
    }


    public boolean locaImmobile(Immobile i, String name) throws GiaLocatoException{
        if(i.isAvailable()){
            if(i.isForCommercialUse()){
                i.affitta();
                i.setNomeConduttore(name);
                return true;
            }
        }
        else {
            throw new GiaLocatoException();
        }
        return false;
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
