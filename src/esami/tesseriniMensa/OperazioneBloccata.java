package esami.tesseriniMensa;

public class OperazioneBloccata extends RuntimeException {
    public OperazioneBloccata(String message) {
        super(message);
    }
}
