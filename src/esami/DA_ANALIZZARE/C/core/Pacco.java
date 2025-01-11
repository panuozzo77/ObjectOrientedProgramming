package esami.DA_ANALIZZARE.C.core;

import javax.management.InvalidAttributeValueException;
import java.util.Date;

public class Pacco {
    private static int i=0;
    private int codicePacco;
    private String descrizione;
    private String tipologia;
    private Date dataArrivo;

    public Pacco(String descrizione, String tipologia, Date dataArrivo)  throws InvalidAttributeValueException {
        if(!(tipologia.equalsIgnoreCase("piccolo") || tipologia.equalsIgnoreCase("medio") ||
                tipologia.equalsIgnoreCase("grande")))
            throw new InvalidAttributeValueException("Tipo deve essere grande, medio o piccolo!");

        codicePacco = i++;
        this.descrizione = descrizione;
        this.tipologia = tipologia;
        this.dataArrivo = dataArrivo;
    }

    public int getCodicePacco() {
        return codicePacco;
    }

    public void setCodicePacco(int codicePacco) {
        this.codicePacco = codicePacco;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String desc) { this.descrizione = desc;}

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipo) {
        this.tipologia = tipo;
    }

    public Date getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(Date dataA) {
        this.dataArrivo = dataA;
    }

    @Override
    public String toString() {
        return "Pacco "+codicePacco+":[Descrizione: "+descrizione+", Tipologia: "+tipologia+", DataArrivo: "+dataArrivo+"]";
    }
}
