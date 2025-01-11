package esami.Conferenze.ui;

import javax.swing.*;

public class FileSelector {

    public static String FileSelectorUI() {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                //JOptionPane.showMessageDialog(null,
                 //       "Selected File: " + fileChooser.getSelectedFile().getAbsolutePath());
                return fileChooser.getSelectedFile().getAbsolutePath();
            }
            return null;
    }
}
