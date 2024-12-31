package esercizietti.classi_anonime_interne;

public class Main {
    public static void main(String[] args) {
        Saluto saluto = new Saluto() {
            @Override
            public void saluta() {
                System.out.println("Ciao!");
            }
        };
        saluto.saluta();
    }
}
