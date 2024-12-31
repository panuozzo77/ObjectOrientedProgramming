package esercizietti.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) throws IOException {
        //FileChooser fileChooser = new FileChooser();
        //String path = fileChooser.getFilePath();
        //System.out.println("hai scelto il file: " + path);
        //FileManager fm = new FileManager();
        //fm.writeFile("prova", "Ciao, questa è una prova");
        //String read = fm.readFile("prova");
        //System.out.println("Ho letto: " + read);

        //System.out.println();

        ObjectManager om = new ObjectManager();
        Entity d1 = new Entity("Michele", "Bartoli", 27);
        Entity d2 = new Entity("Carlo", "Conti", 60);
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(d1);
        entities.add(d2);
        om.writeObjectsToFile("oggetto", entities);
        om.readFromFile("oggetto");
    }



}
