package esercizietti.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    final String root_directory = "/home/cristian/IdeaProjects/POO/src/esercizietti/files/";

    // Method to write multiple objects at once
    public void writeObjectsToFile(String fileName, List<Entity> dataList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(root_directory + fileName))) {
            for (Entity data : dataList) {
                out.writeObject(data);
                System.out.println("Serialized Object: " + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read all objects from a file
    public String readFromFile(String fileName) {
        StringBuilder deserializedString = new StringBuilder(); // Use StringBuilder for better performance
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(root_directory + fileName))) {
            while (true) {
                try {
                    Entity entity = (Entity) in.readObject();
                    System.out.println("Deserialized Entity: " + entity);
                    deserializedString.append(entity.toString()).append("\n"); // Append each entity's string representation
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedString.toString(); // Return the complete string
    }
}
