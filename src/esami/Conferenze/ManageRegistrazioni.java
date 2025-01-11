package esami.Conferenze;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class ManageRegistrazioni {
    private ArrayList<Registrazione> list = new ArrayList<>();

    public void aggiungiRegistrazione(Registrazione r) throws RegistrationException{
        // Controlla se una registrazione con lo stesso nome e cognome esiste già
        for (Registrazione reg : list) {
            if (reg.getNome().equalsIgnoreCase(r.getNome()) && reg.getCognome().equalsIgnoreCase(r.getCognome())) {
                throw new RegistrationException("Registrazione già esistente per: " + r.getNome() + " " + r.getCognome());
            }
        }

        list.add(r);

        // Ordina la lista in base al cognome (e nome come criterio secondario)
        list.sort(Comparator.comparing(Registrazione::getCognome).thenComparing(Registrazione::getNome));
    }

    public ArrayList<Registrazione> dammiRegistrazionePerTipoPartecipante(int x) throws InvalidParameterException {
        check(x);
        boolean isStudente = x == 0;
        ArrayList<Registrazione> accumulator = new ArrayList<>();
        for (Registrazione reg : list) {
            if(reg.isStudente()==isStudente) {
                accumulator.add(reg);
            }
        }
        return accumulator;
    }

    public int dammiTotalePerTipoRegistrazione(int x) {
        check(x);
        int counter = 0;
        boolean isStudente = x == 0;
        for(Registrazione reg : list){
            if(reg.isStudente()==isStudente) {
                counter += reg.calcolaCosto();
            }
        }

        return counter;
    }

    ArrayList<Registrazione> cerca(GregorianCalendar data) {
        ArrayList<Registrazione> accumulator = new ArrayList<>();
        list.stream().filter(t -> t.getData().equals(data)).forEach(t -> accumulator.add(t));
        return accumulator;
    }

    private void check(int x){
        if (!(x == 1 || x == 0)){
            throw new InvalidParameterException("Inserito un valore diverso da 0 o 1");
        }
    }
}
