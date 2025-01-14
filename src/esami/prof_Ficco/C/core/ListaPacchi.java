package esami.prof_Ficco.C.core;

import esami.prof_Ficco.C.interfacce.Lista;

import java.util.Date;

public abstract class ListaPacchi implements Lista {
    private static int count=0;
    private int codice;
    private Date data;
    private Date consegna;

    ListaPacchi(Date d, Date c){
        codice = count++;
        data = d;
        consegna = c;
    }

    abstract void Modifica();

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getConsegna() {
        return consegna;
    }

    public void setConsegna(Date consegna) {
        this.consegna = consegna;
    }
}
