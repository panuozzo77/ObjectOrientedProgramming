package esami.prof_Ficco.A.interfacce;

import esami.prof_Ficco.A.eccezioni.PlayerException;

public interface PersMaster {
    void Ruota(int g);
    void Avanti(int s) throws PlayerException;

    void Indietro(int s) throws PlayerException;
}
