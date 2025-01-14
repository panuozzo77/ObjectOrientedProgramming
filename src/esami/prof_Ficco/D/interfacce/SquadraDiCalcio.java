package esami.prof_Ficco.D.interfacce;

import esami.prof_Ficco.D.core.Giocatore;
import esami.prof_Ficco.D.eccezioni.GiocatoreException;

public interface SquadraDiCalcio {
    void Aggiungi(Giocatore g) throws GiocatoreException;
    void Rimuovi(Giocatore g) throws GiocatoreException;
}
