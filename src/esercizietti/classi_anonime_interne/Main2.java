package esercizietti.classi_anonime_interne;

public class Main2 {
    public static void main(String[] args) {
        Animale gatto = new Animale() {
            @Override
            void verso() {
                System.out.println("Miao Miao");
            }
        };
        gatto.verso();
    }
}
