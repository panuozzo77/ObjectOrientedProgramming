package esercizietti.classi_anonime_interne;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main3_ActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Esempio");
        JButton button = new JButton("Cliccami");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bottone cliccato!");
            }
        });

        frame.add(button);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
