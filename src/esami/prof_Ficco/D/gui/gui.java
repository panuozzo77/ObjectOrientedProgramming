package esami.prof_Ficco.D.gui;

import esami.prof_Ficco.D.core.Squadra;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class gui extends JFrame{
    public gui(Squadra s){
        JPanel mainFrame = buildPanel(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocation(500, 500);
        add(mainFrame);
    }

    public JPanel buildPanel(Squadra s){
        JPanel mainPanel = new JPanel();
        JPanel formPanel = new JPanel();
        JLabel label = new JLabel("Inserisci il nuovo massimo");
        JTextField text = new JTextField("", 2);
        JButton button = new JButton("Modifica");

        button.addActionListener((ActionEvent e) -> {
            s.Modifica(Integer.parseInt(text.getText()));
            System.out.println(s.getMaxGiocatori());
        });
        formPanel.add(label);
        formPanel.add(text);
        formPanel.add(button);
        mainPanel.add(formPanel);

        return mainPanel;
    }
}
