package lab2;

import java.util.Iterator;
import java.util.Scanner;

public class Save {

    public static void main(String[] args) {

        Parametres help = new Parametres();
        if (args.length > 0) {
            if (args[0].equals("-h") || args[0].equals("-help") || args[1].equals("-h") || args[1].equals("-help")) {
                help.help();
            }
        }

        showMenu();
        do{
            char menu = userChoice();
            doAction(menu);
        } while (true);

    }

    public static void showMenu() {
        System.out.println("\na - Enter Data to Process");
        System.out.println("b - Exit");
    }

    public static char userChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Menu Entry: ");
        char userChoice = scanner.next().charAt(0);

        return userChoice;
    }

    public static void doAction(char menuNumber) {

        int countC = 0;
        int countV = 0;

        Container letters = new Container();

        switch (menuNumber) {
            case 'a':
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter data: ");
                String data = scanner.nextLine();

                for (int i = 0; i < data.length() ; i++) {
                    letters.add(String.valueOf(data.charAt(i)));
                }

                Container vowels = new Container();
                vowels.add("a");
                vowels.add("e");
                vowels.add("i");
                vowels.add("o");
                vowels.add("y");
                vowels.add("u");

                Container consonants = new Container();
                consonants.add("q");
                consonants.add("w");
                consonants.add("r");
                consonants.add("t");
                consonants.add("p");
                consonants.add("s");
                consonants.add("d");
                consonants.add("f");
                consonants.add("g");
                consonants.add("h");
                consonants.add("j");
                consonants.add("k");
                consonants.add("l");
                consonants.add("z");
                consonants.add("x");
                consonants.add("c");
                consonants.add("v");
                consonants.add("b");
                consonants.add("n");
                consonants.add("m");

                Iterator<String> iterator = letters.iterator();

                while (iterator.hasNext()) {

                    String item = iterator.next();
                    if(vowels.contains(item.toLowerCase())) {
                        countV++;
                    }
                    else
                    if (consonants.contains(item.toLowerCase())){
                        countC++;
                    }
                }

                System.out.println("\n+---------------+");
                System.out.println("| consonants: " +countC +" |");
                System.out.println("+---------------+");
                System.out.println("|   vowels  : " +countV +" |");
                System.out.println("+---------------+");

                System.out.println("Letters one by one and Size They Occupy in ListContainer:");
                System.out.println(letters.toString());
                System.out.println(letters.size() + "\n");

                System.out.println("Vowels After Removing 'a' and Size They Occupy in Containers:");
                System.out.println(vowels.remove("a"));
                System.out.println(vowels.toString());
                System.out.println(vowels.size() + "\n");

                System.out.println("Vowels ListContainer Contains 'a':");
                System.out.println(vowels.contains("a" + "\n"));

                System.out.println("All Letters Are Present in Vowels ListContainer:");
                System.out.println(vowels.containsAll(letters));

            case 'b':
                System.exit(0);

            default:
                System.out.println("\n WRONG ENTRY!!!");
        }
    }
}