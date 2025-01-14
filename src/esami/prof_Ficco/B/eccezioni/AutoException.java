package esami.prof_Ficco.B.eccezioni;

public class AutoException extends Exception{
    public AutoException(){
        super("Operazione su auto non valida!");
    }

    public AutoException(String s){
        super(s);
    }
}
