package esercizietti.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class FileManager{
    final String root_directory = "/home/cristian/IdeaProjects/POO/src/esercizietti/files/";


    public String writeFile(String fileName, String content) {
        String toWrite = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(root_directory+fileName);
            toWrite = content;
            byte [] w = toWrite.getBytes();
            fos.write(w);
            fos.close();
        } catch (IOException e) {
            System.out.println("File not found");
            System.out.println(e.getMessage());
        }

        return toWrite;
    }

    public String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(root_directory + fileName)) {
            int ch;
            while ((ch = fis.read()) != -1) { // Read until end of file
                content.append((char) ch); // Append each character to the StringBuilder
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString(); // Return the complete content as a string
    }
}
