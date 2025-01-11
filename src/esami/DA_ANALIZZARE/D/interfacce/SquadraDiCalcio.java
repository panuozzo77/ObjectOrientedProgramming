package esami.DA_ANALIZZARE.D.interfacce;

import esami.DA_ANALIZZARE.D.core.Giocatore;
import esami.DA_ANALIZZARE.D.eccezioni.GiocatoreException;

public interface SquadraDiCalcio {
    void Aggiungi(Giocatore g) throws GiocatoreException;
    void Rimuovi(Giocatore g) throws GiocatoreException;
}
