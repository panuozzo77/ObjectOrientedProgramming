package esercizietti.grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SimpleGUI extends JFrame {

    private JTextField textField;

    public SimpleGUI() {
        // Set up JFrame properties
        setTitle("Simple GUI Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create a JPanel with a FlowLayout
        JPanel panel = new JPanel(new FlowLayout());

        // Initialize the JTextField (initially hidden)
        textField = new JTextField(20);
        textField.setEditable(false);
        textField.setVisible(false); // Start hidden

        // Create buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Hide Text");

        // Add action listeners to buttons
        button1.addActionListener(e -> {
            textField.setText("Button 1 pressed!");
            textField.setVisible(true); // Ensure it's visible
        });

        button2.addActionListener(e -> {
            textField.setText("Button 2 pressed!");
            textField.setVisible(true); // Ensure it's visible
        });

        button3.addActionListener(e -> textField.setVisible(false)); // Hide the text field

        // Add components to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(textField);

        // Add the panel to the JFrame
        add(panel);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            SimpleGUI gui = new SimpleGUI();
            gui.setVisible(true); // Show the JFrame
        });
    }
}
