package esami.DA_ANALIZZARE.B.core;

import esami.DA_ANALIZZARE.B.eccezioni.AutoException;
import esami.DA_ANALIZZARE.B.interfacce.Auto;

public abstract class Autovettura implements Auto {

    private boolean acceso=false;
    private String tipoVettura;
    private int numeroRuote;
    private int cilindrata;
    private String colore;
    private static int count=0;

    public void Accendi(Auto a) throws AutoException{
        if(acceso)
            throw new AutoException("Auto già accesa!");
        else
            acceso=true;
    }
    public void Spegni(Auto a) throws AutoException{
        if(acceso)
            acceso=false;
        else
            throw new AutoException("Auto già spenta!");
    }

    public boolean getAcceso(){
        return acceso;
    }

    public Autovettura(String tipoVettura, int numeroRuote, int cilindrata, String colore){
        this.tipoVettura=tipoVettura;
        this.numeroRuote=numeroRuote;
        this.cilindrata=cilindrata;
        this.colore=colore;
        count++;
    }

    public String getTipoVettura() {
        return tipoVettura;
    }

    public void setTipoVettura(String tipoVettura) {
        this.tipoVettura = tipoVettura;
    }

    public int getNumeroRuote() {
        return numeroRuote;
    }

    public void setNumeroRuote(int numeroRuote) {
        this.numeroRuote = numeroRuote;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public String toString(){
        return "tipoVettura: "+tipoVettura+", numeroRuote: "+numeroRuote+", cilindrata: "+cilindrata+", colore: "+colore;
    }
}
