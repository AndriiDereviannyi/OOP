package lab2;

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.util.Iterator;

public class Container implements Iterable<String> , Serializable{

    private String data[];
    private int top;


    public Container() {
        data = new String[5];
        top = -1;
    }

    public Container(int size) {
        data = new String[size];
        top = -1;
    }

    public void add(String item) {
        if (isfull()) {
            resizeContainer();
        }

        top++;
        data[top] = item;


    }

    private void resizeContainer() {
        String[] newContainer = new String[data.length + 5];
        for (int i = 0; i < data.length; i++) {
            newContainer[i] = data[i];
        }
        data = newContainer;
    }

    public boolean isfull() {
        if (top == data.length - 1)
            return true;
        else
            return false;

    }

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

    public String[] toArray() {
        return data;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iter();
    }


    public String toString() {
        String result = "";
        for (int j = 0; j <= top; j++) {
            result += data[j];
            result += ", ";
        }
        return result;
    }

    public void clear() {
        String[] newData = new String[data.length];
        data = newData;
        top = -1;

    }

    public boolean remove(String string) {
        for (int i = 0; i <= top; i++) {
            if (data[i].equals(string)) {
                for (int j = i; j < top; j++) {
                    data[j] = data[j + 1];
                }
                top--;
                return true;
            }
        }

        return false;
    }

    public int size() {

        return top;
    }

    public boolean contains(String value) {

        for (int i = 0; i <= top; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Container otherContainer) {

        for (int i = 0; i <= otherContainer.top; i++) {
            String currentItem = otherContainer.data[i];
            for (int j = 0; j <= top; j++) {
                if (currentItem.equals(data[j])) {
                    break;
                }
                if (j == top) {
                    return false;
                }
            }
        }

        return true;


    }


    private class Iter implements Iterator<String> {
        int cursor = -1;


        @Override
        public boolean hasNext() {
            return cursor != top;
        }

        @Override
        public String next() {
            int index = cursor;
            if (index >= top)
                System.out.println("No more elements");
            else
                cursor = index + 1;

            return data[cursor];
        }

        @Override
        public void remove() {
            for (int i = cursor; i < top; i++) {
                data[i] = data[i + 1];
            }
            data[top] = "";
            top--;
            cursor--;
        }
    }
}


