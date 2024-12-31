package esercizietti.files;

import java.awt.*;

public class FileChooser {

    public String getFilePath(){
        Frame frame = new Frame();
        frame.setVisible(true);

        FileDialog fd = new FileDialog(frame, "Choose File", FileDialog.LOAD);
        fd.setVisible(true);

        return fd.getDirectory() + fd.getFile();
    }
}
