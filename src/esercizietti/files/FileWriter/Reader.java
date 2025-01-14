package esercizietti.files.FileWriter;

import esercizietti.files.SerializedClass.MyClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("fileWriter.txt"));
            String line = "";
            while((line = br.readLine()) != null){
                System.out.println(line);
                list.add(createObject(line));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("La lista contiene: ["+list.size()+"] elementi");
        System.out.println("Stampo dalla lista:\n");
        for(MyClass c : list){
            System.out.println(c);
        }


    }

    private static MyClass createObject(String line){
        int len = line.length();
        int whereIsTheAt = 0;
        int startingPoint = 13;
        int finishName;
        while(true){
            if(line.toCharArray()[startingPoint]==','){
                finishName = startingPoint;
                break;
            }
            else {
                startingPoint++;
            }
        }
        String name = line.substring(14, finishName);
        //System.out.println(name);
        startingPoint = startingPoint + 10;
        String lastname = line.substring(startingPoint, len-1);
        //System.out.println(lastname);
        return new MyClass(name, lastname);
    }
}
