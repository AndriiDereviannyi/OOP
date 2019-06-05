package lab4;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.*;

public class ListContainer<P> implements Iterable<P>, Serializable, List<T> {

    public static final long serialVersionUID = 50L;

    private int top;

    private Node<P> first;

    private Node<P> last;

    public ListContainer() {
        this.top = -1;
        this.first = null;
        this.last = null;
    }

    public boolean Empty() {

        if (first == null) {
            return true;
        }

        return false;
    }

    public void insertFirst(P data) {

        Node<P> newNode = new Node<>(data);

        if (Empty()) {
            last = newNode;
        } else {
            first.setPrevious(newNode);
        }

        newNode.setNext(first);
        first = newNode;
        top++;
    }

    public void insertLast(P data) {

        Node<P> newNode = new Node<>(data);

        if (Empty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
        }

        last = newNode;
        top++;
    }

    public void insertAt(P key, P data) {

        Node<P> current = first;

        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                System.out.println("Element with key " + key + " wasn't found");

                return;
            }
        }

        Node<P> newNode = new Node<>(data);

        if (current == last) {
            last = newNode;
        } else {
            newNode.setNext(current.getNext());
            current.getNext().setPrevious(newNode);
        }

        newNode.setPrevious(current);
        current.setNext(newNode);
        top++;
    }

    public P deleteFirst() {

        Node<P> temp = first;
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrevious(null);
        }
        first = first.getNext();

        top--;

        return temp.getData();
    }

    public P deleteLast() {

        Node<P> temp = last;
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrevious().setNext(null);
        }
        last = last.getPrevious();

        top--;

        return temp.getData();
    }

    public P deleteKey(P key) {

        Node<P> current = first;

        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                System.out.println("Element with key " + key + " wasn't found");

                return null;
            }
        }

        if (current == first) {
            first = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }
        if (current == last) {
            last = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }

        top--;

        return current.getData();
    }

    public P deleteByIndex(int index) {

        int i = 0;

        Node<P> current = first;

        while (current.getData() != null || i != index) {
            current = current.getNext();
            if (current == null) {
                System.out.println("Element with ID " + index + " wasn't found");

                return null;
            }

            i++;
        }

        if (current == first) {
            first = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }
        if (current == last) {
            last = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }

        top--;

        return current.getData();
    }

    public void clearContainer() {

        Node<P> current = first;
        Node<P> previous = first;

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
            previous.setNext(null);
            current.setPrevious(null);
            previous = null;
        }

        first = null;
        last = null;

        top = -1;
    }

    public boolean searchKey(P key) {

        Node<P> current = first;

        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                System.out.println("Element with key " + key + " wasn't found");

                return false;
            }
        }

        return true;
    }

    public void showContainer() {
        Node<P> current = first;

        while (current != null) {

            current.showNode();

            current = current.getNext();
        }


    }

    public Object[] toArray() {

        List<P> objects = new ArrayList<>();

        Node<P> current = first;

        while (current.getNext() != null) {

            objects.add(current.getData());

            current = current.getNext();
        }


        return objects.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();


        Node<P> current = first;

        while (current.getNext() != null) {

            sb.append("<-").append(current.getData()).append("->");

            current = current.getNext();
        }

        return sb.toString();
    }

    public int size() {

        int counter = 0;
        Node<P> current = first;

        while (current != null) {

            counter++;
            current = current.getNext();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public P findByIndex(int index) {

        int counter = 0;
        Node<P> current = first;

        while (counter != index || current.getNext() != null) {
            counter++;
            current = current.getNext();
        }

        return current.getData();
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public Node<P> getFirst() {
        return first;
    }

    public void setFirst(Node<P> first) {
        this.first = first;
    }

    public Node<P> getLast() {
        return last;
    }

    public void setLast(Node<P> last) {
        this.last = last;
    }

    public static <T> void serialize(ListContainer<T> list, String filename) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(list);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static <T> ListContainer<T> deserialize(String filename) {
        ListContainer<T> somelist = null;

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            somelist = (ListContainer<T>) in.readObject();

            in.close();
            file.close();

            System.out.println("Data was loaded from file : " + filename);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        return somelist;
    }

    public static <T> ListContainer<T> loadFromXML() {
        ListContainer<T> somelist = null;


        try {
            String filePath = FolderSelector.doFile();
            File userFile = new File(filePath);
            if (userFile.getName().substring(userFile.getName().length() - 4).equals(".xml")) {
                XmlMapper xmlMapper = new XmlMapper();
                String xml = inputStreamToString(new FileInputStream(userFile));
                somelist = xmlMapper.readValue(xml, ListContainer.class);
            } else {
                System.out.println("Wrong File");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return somelist;


    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public static <T> void savetoXML(ListContainer<T> list) {

        try {
            File userFile = new File(FolderSelector.doFile());

            if (userFile.getName().substring(userFile.getName().length() - 4).equals(".xml")) {
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.writeValue(userFile, list);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<P> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<P> {
        int cursor = -1;


        @Override
        public boolean hasNext() {
            return cursor != top;
        }

        @Override
        public P next() {
            int index = cursor;
            if (index >= top)
                System.out.println("No more elements");
            else
                cursor = index + 1;

            return findByIndex(cursor);
        }

        @Override
        public void remove() {
        }
    }
}
