package esami.DA_ANALIZZARE.B.GUI;

import esami.DA_ANALIZZARE.B.core.Autovettura;
import esami.DA_ANALIZZARE.B.core.Camion;
import esami.DA_ANALIZZARE.B.core.Macchina;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class gui extends JFrame {
    public gui(List<Autovettura> l){
        setSize(500, 500);
        setLocation(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(buidlPanel(l));
    }

    public JPanel buidlPanel(List<Autovettura> l){
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        JLabel tipoVettura = new JLabel("Tipo vettura?");
        JTextField tipoVetturaText = new JTextField("", 20);

        JLabel numeroRuote = new JLabel("Numero di ruote?");
        JTextField numeroRuoteText = new JTextField("", 20);

        JLabel cilindrata = new JLabel("Cilindrata?");
        JTextField cilindrataText = new JTextField("", 20);

        JLabel colore = new JLabel("colore vettura?");
        JTextField coloreText = new JTextField("", 20);

        JLabel matricola = new JLabel("Matricola vettura?");
        JTextField matricolaText = new JTextField("", 20);

        JLabel targa = new JLabel("Targa vettura?");
        JTextField targaText = new JTextField("", 20);

        JLabel nMarce = new JLabel("Quante marce ha?");
        JTextField nMarceText = new JTextField("", 20);

        JLabel lunghezza = new JLabel("Lunghezza camion?");
        JTextField lunghezzaText = new JTextField("", 20);

        JLabel peso = new JLabel("Quante marce ha?");
        JTextField pesoText = new JTextField("", 20);

        JLabel limiteV = new JLabel("Quante marce ha?");
        JTextField limiteVText = new JTextField("", 20);


        form.add(tipoVettura);
        form.add(tipoVetturaText);
        form.add(numeroRuote);
        form.add(numeroRuoteText);
        form.add(cilindrata);
        form.add(cilindrataText);
        form.add(colore);
        form.add(coloreText);
        form.add(matricola);
        form.add(matricolaText);
        form.add(targa);
        form.add(targaText);
        form.add(nMarce);
        form.add(nMarceText);
        form.add(lunghezza);
        form.add(lunghezzaText);
        form.add(peso);
        form.add(pesoText);
        form.add(limiteV);
        form.add(limiteVText);

        JButton newM = new JButton("Crea nuova macchina");
        JButton newC = new JButton("Crea nuovo camion");

        newM.addActionListener((ActionEvent e)->{
            Macchina m = new Macchina(tipoVetturaText.getText(), Integer.parseInt(numeroRuoteText.getText()),
                    Integer.parseInt(cilindrataText.getText()), coloreText.getText(), Integer.parseInt(matricolaText.getText()),
                    targaText.getText(), Integer.parseInt(nMarceText.getText()));
            l.add(m);
        });

        newC.addActionListener((ActionEvent j) -> {
            Camion c = new Camion(coloreText.getText(), Integer.parseInt(matricolaText.getText()),
                    targaText.getText(), Integer.parseInt(nMarceText.getText()), Float.parseFloat(lunghezzaText.getText()),
                    Float.parseFloat(pesoText.getText()), Integer.parseInt(limiteVText.getText()));
            l.add(c);
        });

        form.add(newM);
        form.add(newC);
        return form;
    }
}
