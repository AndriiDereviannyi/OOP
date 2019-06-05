package lab2;

import java.util.Iterator;

public class ContainerTester {

    public static void main(String[] args) {
        Container somecontainer = new Container();
        somecontainer.add("First");
        somecontainer.add("Andy");
        somecontainer.add("Vicky");
        somecontainer.add("Nastya");
        somecontainer.add("Oleg");
//        somecontainer.add("Danilo");
        somecontainer.add("Andy");


        Container nextContainer = new Container();
        nextContainer.add("Nastya");
        nextContainer.add("Oleg");
        nextContainer.add("Danilo");
        nextContainer.add("Andy");

//        Iterator<String> ite = somecontainer.iterator();
//
//        ite.next();
//        ite.remove();
//        ite.next();
//        ite.remove();
//
//        while (ite.hasNext()) {
//            System.out.println(ite.next());
//        }


        System.out.println(somecontainer.toString());

//       somecontainer.clear();

        System.out.println(somecontainer.size());

        System.out.println(somecontainer.remove("Andy"));

        System.out.println(somecontainer.toString());

        System.out.println(somecontainer.size());

        System.out.println(somecontainer.contains("Sab"));

        System.out.println(somecontainer.containsAll(nextContainer));
    }


}
