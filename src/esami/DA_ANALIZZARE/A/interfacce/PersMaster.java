package esami.DA_ANALIZZARE.A.interfacce;

import esami.DA_ANALIZZARE.A.eccezioni.PlayerException;

public interface PersMaster {
    void Ruota(int g);
    void Avanti(int s) throws PlayerException;

    void Indietro(int s) throws PlayerException;
}
