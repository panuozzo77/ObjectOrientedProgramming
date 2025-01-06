package esercizietti.eccezioni;

public class Dispositivo {
    private String nome;
    private boolean disponibile;
    final String operazione;

    public Dispositivo(String nome, String operazione) {
        this.nome = nome;
        this.disponibile = true;
        this.operazione = operazione;
    }

    public Dispositivo(String nome, String operazione, boolean disponibile) {
        this.nome = nome;
        this.disponibile = disponibile;
        this.operazione = operazione;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isDisponibile() {
        return disponibile;
    }
    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public void utilizza() throws MyException {
        if(disponibile) {
            System.out.println("["+ nome +"]: " + operazione);
        }
        else{
            String error = "[" + nome +"] è spento!";
            throw new MyException(error);
        }
    }

}
