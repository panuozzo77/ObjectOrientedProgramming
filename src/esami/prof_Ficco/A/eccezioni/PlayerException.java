package esami.prof_Ficco.A.eccezioni;

public class PlayerException extends Exception{
    public PlayerException(){
        super("Azione non valida!");
    }

    public PlayerException(String s){
        super(s);
    }
}
