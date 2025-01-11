package esame.AgenziaImmobiliare;

import esami.AgenziaImmobiliare.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Starter {

    private AgenziaImmobiliare agenzia;
    private JComboBox<String> comboBox;
    private JLabel esitoLabel;

    private static ArrayList<Immobile> generate(){
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

    public Starter() {
        // Crea un oggetto AgenziaImmobiliare con 20 immobili
        ArrayList<Immobile> immobili = generate();
        agenzia = new AgenziaImmobiliare(immobili);

        // Crea l'interfaccia grafica
        JFrame frame = new JFrame("Agenzia Immobiliare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // ComboBox con la lista degli immobili non locati
        comboBox = new JComboBox<>();
        aggiornaComboBox();
        panel.add(comboBox, BorderLayout.NORTH);

        // Pannello per locazione
        JPanel locazionePanel = new JPanel();
        locazionePanel.setLayout(new FlowLayout());
        JTextField conduttoreField = new JTextField(15);
        JButton locareButton = new JButton("Loca Immobile");
        locazionePanel.add(new JLabel("Conduttore:"));
        locazionePanel.add(conduttoreField);
        locazionePanel.add(locareButton);

        // Esito operazione
        esitoLabel = new JLabel(" ");
        esitoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        esitoLabel.setForeground(Color.BLUE);

        panel.add(locazionePanel, BorderLayout.CENTER);
        panel.add(esitoLabel, BorderLayout.SOUTH);

        // Aggiungi azione al bottone per locare l'immobile
        locareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conduttore = conduttoreField.getText().trim();
                if (conduttore.isEmpty()) {
                    esitoLabel.setText("Inserisci un nome per il conduttore.");
                    return;
                }

                int selectedIndex = comboBox.getSelectedIndex();
                if (selectedIndex < 0) {
                    esitoLabel.setText("Seleziona un immobile dalla lista.");
                    return;
                }

                // Recupera l'immobile selezionato e prova a locarlo
                Immobile immobile = agenzia.getImmobiliNonLocati().get(selectedIndex);
                boolean esito = false;
                try {
                    esito = agenzia.locaImmobile(immobile, conduttore);
                } catch (GiaLocatoException ex) {
                    throw new RuntimeException(ex);
                }

                if (esito) {
                    esitoLabel.setText("Immobile locato con successo a " + conduttore + "!");
                    aggiornaComboBox();
                } else {
                    esitoLabel.setText("Errore: non è stato possibile locare l'immobile.");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void aggiornaComboBox() {
        comboBox.removeAllItems();
        for (Immobile immobile : agenzia.getImmobiliNonLocati()) {
            comboBox.addItem(immobile.toString());
        }
    }

    public static void main(String[] args) {
        new Starter();
    }
}
