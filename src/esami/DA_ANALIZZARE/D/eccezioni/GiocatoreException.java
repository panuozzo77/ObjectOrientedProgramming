package esami.DA_ANALIZZARE.D.eccezioni;

public class GiocatoreException extends Exception{
    public GiocatoreException(){
        super("Operazione non valida per questo Giocatore!");
    }
    public GiocatoreException(String s){
        super(s);
    }
}
