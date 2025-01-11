package esami.Conferenze;

public class DataRegistrazione {
    private int giorno;
    private int mese;
    private int anno;

    public DataRegistrazione(int giorno, int mese, int anno) throws BadDateException {
        if(giorno <= 0 || giorno > 31 || mese <= 0 || mese > 12 || anno <= 0) {
            throw new BadDateException("Formato Data Errato");
        }
        if(anno > 2020 && mese >= 5){
            throw new BadDateException("Data superiore al 30 aprile 2020!");
        }
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
