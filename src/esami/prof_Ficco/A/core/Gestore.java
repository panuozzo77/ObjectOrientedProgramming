package esami.prof_Ficco.A.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gestore {
    private List<Personaggio> personaggi;

    public Gestore(int n){
        personaggi = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(Math.random()>0.5){
                Orco o = new Orco(100, 0, 0f);
                personaggi.add(o);
            }
            else{
                Cavaliere c = new Cavaliere(100, 0, 0f);
                personaggi.add(c);
            }

        }

    }

    public int getPos(Personaggio pers){
        return personaggi.get(personaggi.indexOf(pers)).getPosizioneAttuale();
    }

    public Map<Personaggio, List<String>> getPosAll(){
        Map<Personaggio, List<String>> result = new HashMap<>();
        for(Personaggio p: personaggi){
            List<String> s = new ArrayList<>();
            s.add((String.valueOf(p.getPosizioneAttuale())));
            s.add(p.getTipo());
            result.put(p, s);
        }
        return result;
    }

    public String getType(Personaggio pers){
        return pers.getTipo();
    }

    public List<Personaggio> getPersonaggi() {
        return personaggi;
    }

    public void setPersonaggi(List<Personaggio> personaggi) {
        this.personaggi = personaggi;
    }


}
