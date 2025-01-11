package esami.Conferenze;

import esami.Conferenze.ui.FileSelector;
import esami.Conferenze.ui.Manager;

public class Main {
    public static void main(String[] args) {
        String path = FileSelector.FileSelectorUI();
        System.out.println(path);
        Manager.viewer(path);
    }
}
