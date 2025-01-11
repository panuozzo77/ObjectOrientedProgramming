package esami.DA_ANALIZZARE.B.core;

public class Macchina extends Autovettura{

    private int matricola;
    private String targa;
    private int nMarce;

    public Macchina(String tipoVettura, int numeroRuote, int cilindrata, String colore, int matricola, String targa, int nMarce) {
        super(tipoVettura, numeroRuote, cilindrata, colore);
        this.matricola=matricola;
        this.targa=targa;
        this.nMarce=nMarce;
    }
    public void Avanti(){
        if(super.getAcceso())
            System.out.println("Mi muovo in avanti");
        else
            System.out.println("La macchina è spenta");
    }

    public void Indietro(){
        if(super.getAcceso())
            System.out.println("Mi muovo indietro");
        else
            System.out.println("La macchina è spenta");
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getnMarce() {
        return nMarce;
    }

    public void setnMarce(int nMarce) {
        this.nMarce = nMarce;
    }

    @Override
    public String toString(){
        String padre = super.toString();
        return "Macchina ["+padre+", matricola: "+matricola+", targa: "+targa+", nMarce: "+nMarce+"]";
    }
}
