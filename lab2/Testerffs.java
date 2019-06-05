package lab2;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;

public class Testerffs {
    private static Container data = null;

    public static void main(String[] args) {

        ParametresForTester help = new ParametresForTester();
        if (args.length>0) {
            if (args[0].equals("-h") || args[0].equals("-help") || args[1].equals("-h") || args[1].equals("-help")) {
                help.helpp();
            }
        }

        data = Container.loadfromfile("data.ser");

        if(data == null){
            data = new Container();
        }

        showMenu();

        do{
            int menu = userChoice();
            doAction(menu);
        } while (true);


    }

    public static void showMenu(){

        System.out.println("\nCommands:");
        System.out.println("\t1 - Enter Data");
        System.out.println("\t2 - Display ListContainer in Form of a Line");
        System.out.println("\t3 - Add Desirable Element to the End of the ListContainer");
        System.out.println("\t4 - Remove First Occurrence of Desirable Element from the ListContainer");
        System.out.println("\t5 - Display Array of all Objects in the ListContainer");
        System.out.println("\t6 - RegexCheck if Desired Elements are Present in the ListContainer");
        System.out.println("\t7 - Clear the ListContainer");
        System.out.println("\t0 - Exit");
    }

    public static int userChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Menu Entry: ");
        int userChoice = scanner.nextInt();

        return userChoice;
    }

    public static void doAction(int menuNumber){
        switch(menuNumber){
            case 1: enteringData(); break;
            case 2: showContainerContent(); break;
            case 3: addElement(); break;
            case 4: removeElement(); break;
            case 5: showArray(); break;
            case 6: checkElements(); break;
            case 7: clearAll(); break;
            case 0: Container.savetofile(data, "data.ser");
                System.exit(0);
            default:
                System.out.println("\nWrong Entry");
        }
    }

    public static void enteringData(){
        Scanner scanner = new Scanner(System.in);

        data.clear();


        System.out.println("Enter data: ");
        String entry = scanner.nextLine();

        for (int i = 0; i < entry.length() ; i++) {
            data.add(String.valueOf(entry.charAt(i)));
        }
    }

//    //toString
//    public static void showContainerContent() {
//        System.out.println("\nContainer Data: ");
//        System.out.println(data.toString());
//    }

    //while
    public static void showContainerContent() {
        System.out.println("ListContainer Data: ");

        Iterator<String> iterator = data.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

//    //for each
//    public static void showContainerContent() {
//        System.out.println("ListContainer Data: ");
//
//        for(String item: data){
//            System.out.println(item);
//        }
//    }

    public static void addElement(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Data to Add:");
        String toAdd = scanner.nextLine();

        data.add(toAdd);

        System.out.println(data);
    }

    public static void removeElement() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Data for Removal:");
        String toRemove = scanner.nextLine();

        System.out.println(data.remove(toRemove));

        System.out.println(data);
    }

    public static void showArray() {
        String[] arr = data.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void checkElements() {
        Container data2 = new Container();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Data for Comparison: ");
        String entry = scanner.nextLine();

        for (int i = 0; i < entry.length() ; i++) {
            data2.add(String.valueOf(entry.charAt(i)));
        }

        System.out.println(data.containsAll(data2));
    }

    public static void clearAll() {
        data.clear();
        System.out.println("Done");
    }

}