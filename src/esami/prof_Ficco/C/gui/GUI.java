package esami.prof_Ficco.C.gui;

import esami.prof_Ficco.C.core.ListaPacchiNatale;
import esami.prof_Ficco.C.core.Pacco;

import javax.management.InvalidAttributeValueException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class GUI extends JFrame {
    public GUI(ListaPacchiNatale l){
        setLocation(500, 500);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel main = buildPanel(l);
        add(main);
        setVisible(true);
    }

    private static JPanel buildPanel(ListaPacchiNatale l){
        JPanel main = new JPanel();
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        JLabel descrizione = new JLabel("Descrizione pacco");
        JTextField descText = new JTextField("", 3);
        JPanel descPanel = new JPanel();
        descPanel.add(descrizione);
        descPanel.add(descText);

        JLabel tipologia = new JLabel("Tipo pacco [Grande / Medio / Piccolo]");
        JTextField tipoText = new JTextField("", 3);
        JPanel tipoPanel = new JPanel();
        tipoPanel.add(tipologia);
        tipoPanel.add(tipoText);

        JLabel data = new JLabel("Data Arrivo pacco [YYYY-MM-DD]");
        JTextField dataText = new JTextField("", 3);
        JPanel dataPanel = new JPanel();
        dataPanel.add(data);
        dataPanel.add(dataText);

        JButton reset = new JButton("Reset");
        JButton add = new JButton("Aggiungi pacco");

        reset.addActionListener((ActionEvent e) -> {
            descText.setText("");
            tipoText.setText("");
            dataText.setText("");
        });

        add.addActionListener((ActionEvent x) -> {
            if(!descText.getText().equalsIgnoreCase("") && !tipoText.getText().equalsIgnoreCase("") && !dataText.getText().equalsIgnoreCase("")){
                try {
                    Pacco p = new Pacco(descText.getText(), tipoText.getText(), Date.valueOf(dataText.getText()));
                    l.Aggiungi(p);
                } catch (InvalidAttributeValueException e) {
                    throw new RuntimeException(e);
                }

            }
        } );
        form.add(descPanel);
        form.add(tipoPanel);
        form.add(dataPanel);
        form.add(reset);
        form.add(add);
        main.add(form);

        return main;
    }
}
