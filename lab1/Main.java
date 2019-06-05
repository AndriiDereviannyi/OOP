package lab1;

import java.util.Scanner;

public class Main {

    public static String data;

    public static int consonant;
    public static int vowel;

    public static void main(String[] args) {

        Parametres help = new Parametres();
        if (args.length>0) {
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
        System.out.println("\na - Enter Data");
        System.out.println("b - View Data");
        System.out.println("c - Process Data");
        System.out.println("d - Show Result");
        System.out.println("e - Exit");
    }

    public static char userChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Menu Entry: ");
        char userChoice = scanner.next().charAt(0);

        return userChoice;
    }

    public static void doAction(char menuNumber) {
        switch (menuNumber) {
            case 'a':
                data = Actions.enteringdata();
                break;
            case 'b':
                Actions.showdata(data);
                break;
            case 'c':
                vowel = Actions.coutVowel(data);
                consonant = Actions.coutConsonant(data);
                System.out.println("Done");
                break;
            case 'd':
                Actions.showResult(vowel, consonant);

            case 'e':
                System.exit(0);

            default:
                System.out.println("\n WRONG ENTRY!!!");
        }
    }
}