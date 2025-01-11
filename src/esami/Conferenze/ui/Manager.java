package esami.Conferenze.ui;

import javax.swing.*;
import esami.Conferenze.*;
import esami.Conferenze.exception.RegistrationException;
import esami.Conferenze.ManageRegistrazioni;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Manager {

    public static void viewer(String path) {
        // Load registrations from the file
        ManageRegistrazioni registrazioni = loadFromFile(path);

        // Create the main frame
        JFrame frame = new JFrame("Manage Registrations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Panel for controls
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new FlowLayout());

        JButton viewStudentsButton = new JButton("Vedi Studenti");
        JButton viewProfessionalsButton = new JButton("Vedi Professionisti");
        JTextField dateField = new JTextField(10);
        JButton searchByDateButton = new JButton("Cerca per data");

        controlsPanel.add(viewStudentsButton);
        controlsPanel.add(viewProfessionalsButton);
        controlsPanel.add(new JLabel("Data (yyyy-MM-dd):"));
        controlsPanel.add(dateField);
        controlsPanel.add(searchByDateButton);

        frame.add(controlsPanel, BorderLayout.NORTH);

        // Table to display registrations
        String[] columnNames = {"Nome", "Cognome", "Data", "Tipo", "Tasse"};
        JTable table = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(table);
        frame.add(tableScrollPane, BorderLayout.CENTER);

        // Panel for totals
        JPanel totalsPanel = new JPanel();
        totalsPanel.setLayout(new GridLayout(1, 2));

        JLabel studentsTotalLabel = new JLabel("Tasse Studenti: 0");
        JLabel professionalsTotalLabel = new JLabel("Tasse Professionisti: 0");

        totalsPanel.add(studentsTotalLabel);
        totalsPanel.add(professionalsTotalLabel);

        frame.add(totalsPanel, BorderLayout.SOUTH);

        // Action Listeners for buttons
        viewStudentsButton.addActionListener(e -> {
            updateTable(table, registrazioni.dammiRegistrazionePerTipoPartecipante(0));
        });

        viewProfessionalsButton.addActionListener(e -> {
            updateTable(table, registrazioni.dammiRegistrazionePerTipoPartecipante(1));
        });

        searchByDateButton.addActionListener(e -> {
            try {
                String dateText = dateField.getText();
                String[] parts = dateText.split("-");
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]) - 1; // Months are zero-based
                int day = Integer.parseInt(parts[2]);

                GregorianCalendar date = new GregorianCalendar(year, month, day);
                updateTable(table, registrazioni.cerca(date));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid date format. Please use yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Calculate totals
        studentsTotalLabel.setText("Tasse Studenti: " + registrazioni.dammiTotalePerTipoRegistrazione(0));
        professionalsTotalLabel.setText("Tasse Professionisti: " + registrazioni.dammiTotalePerTipoRegistrazione(1));

        // Show the frame
        frame.setVisible(true);
    }

    private static ManageRegistrazioni loadFromFile(String path) {
        ManageRegistrazioni registrazioni = new ManageRegistrazioni();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            while (true) {
                Registrazione read = (Registrazione) ois.readObject();
                registrazioni.aggiungiRegistrazione(read);
            }
        } catch (EOFException e) {
            // End of file reached, expected behavior
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Error reading or deserializing file: " + path, e);
        } catch (RegistrationException e) {
            throw new IllegalStateException("Error adding registration to manager", e);
        }
        return registrazioni;
    }

    private static void updateTable(JTable table, ArrayList<Registrazione> registrazioni) {
        String[] columnNames = {"Nome", "Cognome", "Data", "Tipo", "Tasse"};
        String[][] data = new String[registrazioni.size()][5];

        for (int i = 0; i < registrazioni.size(); i++) {
            Registrazione r = registrazioni.get(i);
            data[i][0] = r.getNome();
            data[i][1] = r.getCognome();
            data[i][2] = r.getData().getTime().toString(); // Convert GregorianCalendar to String
            data[i][3] = r.isStudente() ? "Studente" : "Professionista";
            data[i][4] = String.valueOf(r.calcolaCosto());
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

}
