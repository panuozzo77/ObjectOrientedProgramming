package esami.AgenziaImmobiliare;

public class Immobile {
    private String nomeLocatore;
    private String nomeConduttore;
    private String indirizzo;
    private boolean forCommercialUse;
    private boolean isFree;

    public String getNomeConduttore() {
        return nomeConduttore;
    }

    public void setNomeConduttore(String nomeConduttore) {
        this.nomeConduttore = nomeConduttore;
    }

    public Immobile(String nome, String nomeC, String indirizzo, boolean commercial) {
        this.nomeLocatore = nome;
        this.nomeConduttore = nomeC;
        this.indirizzo = indirizzo;
        this.forCommercialUse = commercial;
        isFree = true;
    }

    public boolean isForCommercialUse() {
        return forCommercialUse;
    }

    public boolean isAvailable(){ return isFree;}

    public void sellIt() { isFree = false;}

    public void libera(){ isFree = true;}

    public void affitta(){
        sellIt();
    };

    public void affitta(int n) throws ResidentialException{
        sellIt();
    };

    @Override
    public String toString() {
        return "Immobile{" +
                "nomeLocatore='" + nomeLocatore + '\'' +
                ", nomeConduttore='" + (nomeConduttore != null ? nomeConduttore : "None") + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", forCommercialUse=" + forCommercialUse +
                ", isFree=" + isFree +
                '}';
    }
}
