package esami.DA_ANALIZZARE.A.eccezioni;

public class PlayerException extends Exception{
    public PlayerException(){
        super("Azione non valida!");
    }

    public PlayerException(String s){
        super(s);
    }
}
