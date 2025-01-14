package esami.prof_Ficco.A.gui;

import esami.prof_Ficco.A.core.Gestore;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    private Gestore g;
    public GUI(){
        setSize(500,500);
        setLocation(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(buildPanel());
    }

    private JPanel buildPanel(){
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        JLabel n = new JLabel("Quanti personaggi?");
        JTextField nText = new JTextField("", 1);
        JButton b = new JButton("Crea lista");
        b.addActionListener((ActionEvent e) -> {
            this.g = new Gestore(Integer.parseInt(nText.getText()));
        });
        form.add(n);
        form.add(nText);
        form.add(b);
        return form;
    }

    public Gestore getGestore(){
        return this.g;
    }

}
