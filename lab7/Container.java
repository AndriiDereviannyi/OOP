package lab7;

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.util.Iterator;

public class Container implements Serializable{



    public static void savetofile(Container somecontainer, String filename) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(somecontainer);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static Container loadfromfile(String filename) {
        Container somecontainer = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            somecontainer = (Container) in.readObject();

            in.close();
            file.close();

            System.out.println("Data was loaded from file : "+filename);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        return somecontainer;
    }
}


