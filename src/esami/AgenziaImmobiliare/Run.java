package AgenziaImmobiliare;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Run {
    public void main(String[] args){
        generate();
    }

    private ArrayList<Immobile> generate(){
        Random random = new Random();
        ArrayList<Immobile> immobili = new ArrayList<>();

        // Generate 10 random Commerciale instances
        for (int i = 0; i < 10; i++) {
            String nome = "Locatore" + (i + 1);
            String nomeC = "Conduttore" + (i + 1);
            String indirizzo = "Via Commerciale " + (i + 1);
            boolean commerciale = true;
            int m2 = random.nextInt(200) + 50; // Random area between 50 and 250
            boolean isPolluting = random.nextBoolean();

            Commerciale commercialeImmobile = new Commerciale(nome, nomeC, indirizzo, commerciale, m2, isPolluting);
            commercialeImmobile.calcolaTasse();
            immobili.add(commercialeImmobile);
        }

        // Generate 10 random Residenziale instances
        for (int i = 0; i < 10; i++) {
            String nome = "Locatore" + (i + 11);
            String nomeC = "Conduttore" + (i + 11);
            String indirizzo = "Via Residenziale " + (i + 1);
            boolean commerciale = false;
            int vani = random.nextInt(5) + 1; // Random number of rooms between 1 and 5
            int residenti = random.nextInt(vani * 3); // Random residents up to 3 times the number of rooms
            int piano = random.nextInt(5) + 1; // Random floor between 1 and 5

            try {
                Residenziale residenzialeImmobile = new Residenziale(nome, nomeC, indirizzo, commerciale, vani, residenti, piano);
                immobili.add(residenzialeImmobile);
            } catch (ResidentialException e) {
                System.err.println("Error creating Residenziale: " + e.getMessage());
            }
        }

        // Print all generated instances
        System.out.println("Generated Immobili:");
        for (Immobile immobile : immobili) {
            System.out.println(immobile);
        }

        return immobili;
    }
}
