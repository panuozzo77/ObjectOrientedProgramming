package esercizietti.grafica.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    Authenticator auth = new Authenticator();

    public GUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        panel.setLayout(new GridLayout(6, 1));

        JTextField username = new JTextField("Username");
        JPasswordField passwordField = new JPasswordField("Password");
        JLabel label = new JLabel();
        JButton logout = new JButton("Logout");

        // Add components to the panel
        panel.add(username);
        panel.add(passwordField);
        panel.add(label);
        panel.add(logout);

        // Initially hide the label and logout button
        label.setVisible(false);
        logout.setVisible(false);

        // Action listener for login (ENTER in username field)
        username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = username.getText();
                String enteredPassword = new String(passwordField.getPassword()); // Get password securely

                try {
                    if (auth.authenticate(enteredUsername, enteredPassword)) {
                        label.setText(enteredUsername + " Benvenuto!");
                        label.setVisible(true);
                        logout.setVisible(true);
                    }
                } catch (UserNotFoundException ex) {
                    JOptionPane.showMessageDialog(frame, "L'Utente o password non coincidono!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action listener for logout button
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setVisible(false);
                logout.setVisible(false);
                username.setText("Username");
                passwordField.setText("Password");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
