package lab1;

import java.util.Scanner;

public class Actions {

    public static String enteringdata() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Data: ");


        return scanner.nextLine();
    }

    public static void showdata(String data) {
        System.out.println(data);

    }

    public static int coutVowel(String data) {
        char[] vowels={'a','e','y','u','i','o'};

        int counter = 0;
        for (int i = 0; i < data.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {

                if (data.toLowerCase().charAt(i) == vowels[j])
                    counter++;
            }
        }
        return counter;
    }

    public static int coutConsonant(String data) {
        char[] consonants={'q','w','r','t','p','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};

        int counter = 0;
        for (int i = 0; i < data.length(); i++) {
            for (int j = 0; j < consonants.length; j++) {

                if (data.toLowerCase().charAt(i) == consonants[j])
                    counter++;
            }
        }
        return counter;
    }

    public static void showResult(int vowel, int consonant) {
        System.out.println("\n+---------------+");
        System.out.println("| consonants: " +consonant +" |");
        System.out.println("+---------------+");
        System.out.println("|   vowels  : " +vowel +" |");
        System.out.println("+---------------+");
    }
}