package esami.AgenziaImmobiliare;

public class GiaLocatoException extends Exception {
  public GiaLocatoException() {
    super("L'immobile è già allocato");
  }
}
