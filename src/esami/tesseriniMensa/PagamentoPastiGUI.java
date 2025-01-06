package esami.tesseriniMensa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagamentoPastiGUI {
    private PagamentoPasti manager = new PagamentoPasti();
    private JTextArea outputArea;

    public PagamentoPastiGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Gestione Tesserini Mensa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Create the file load panel
        JPanel filePanel = new JPanel();
        JButton loadButton = new JButton("Carica File");
        filePanel.add(loadButton);

        // Create the payment panel
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new FlowLayout());
        JLabel codeLabel = new JLabel("Codice Tesserino:");
        JTextField codeField = new JTextField(10);
        JButton payButton = new JButton("Paga");
        paymentPanel.add(codeLabel);
        paymentPanel.add(codeField);
        paymentPanel.add(payButton);

        // Create the output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add panels to the frame
        frame.add(filePanel, BorderLayout.NORTH);
        frame.add(paymentPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Action for loading file
        loadButton.addActionListener(e -> loadFile());

        // Action for processing payment
        payButton.addActionListener(e -> {
            String codeText = codeField.getText();
            try {
                int code = Integer.parseInt(codeText);
                boolean success = manager.usaTesserino(code);
                if (success) {
                    outputArea.append("Pagamento effettuato per Tesserino #" + code + "\n");
                } else {
                    outputArea.append("Tesserino #" + code + " non trovato.\n");
                }
            } catch (NumberFormatException ex) {
                outputArea.append("Inserire un numero valido per il codice del Tesserino.\n");
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    private void loadFile() {
        // Open a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                manager.loadFromFile(filePath);
                outputArea.append("File caricato con successo: " + filePath + "\n");
            } catch (Exception e) {
                outputArea.append("Errore nel caricamento del file: " + e.getMessage() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PagamentoPastiGUI::new);
    }
}
