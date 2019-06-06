package lab6;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public void ptintMainMenu() {

                printSecondMenu();

    }

    private void printSecondMenu(){
        Actions f1 = new Actions(1);
        Actions f2 = new Actions(2);
        Actions f3 = new Actions(3);
        Actions f4 = new Actions(4);
        Thread thread1 = new Thread(f1);
        Thread thread2 = new Thread(f2);
        Thread thread3 = new Thread(f3);
        Thread thread4 = new Thread(f4);

        System.out.println("\nCommands:");
        System.out.println("1 - Show The Shortest Word");
        System.out.println("2 - Show The Longest Word");
        System.out.println("3 - Show The Word With The Most Consonants");
        System.out.println("4 - Show The Word With The Most Vowels");
        System.out.println("0 - Exit");
        System.out.println("\n\nMenu Entry: ");
        Scanner scanner = new Scanner(System.in);
        char[] t = scanner.nextLine().toCharArray();

        if (Arrays.binarySearch(t, '0')>=0){
            System.exit(0);
        }

        System.out.println("\nInput Time Limit: ");
        double time_limit = scanner.nextDouble();

        Long time;
        time = System.currentTimeMillis();
        if (Arrays.binarySearch(t, '1')>=0){
            thread1.start();
        }
        if (Arrays.binarySearch(t, '2')>=0){
            thread2.start();
        }
        if (Arrays.binarySearch(t, '3')>=0){
            thread3.start();
        }
        if (Arrays.binarySearch(t, '4')>=0){
            thread4.start();
        }


        if (time_limit==0){
            while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive()){

            }
        }else {
            while (true){
                if (!thread1.isAlive() && !thread2.isAlive() && !thread3.isAlive() && !thread4.isAlive()){
                    break;
                }
                if (time_limit<System.currentTimeMillis()-time){
                    thread1.stop();
                    thread2.stop();
                    thread3.stop();
                    thread4.stop();
                    break;
                }
            }
        }
        System.out.println("Running in Parallel: " + (System.currentTimeMillis()-time) + " ms");

        time = System.currentTimeMillis();
        for (int i=0;i<t.length;i++){
            Actions f = new Actions();
           switch (Character.getNumericValue(t[i])){
               case 1:
                   f.getMin();
                   break;
               case 2:
                   f.getMax();
                   break;
               case 3:
                   f.maxConsonants();
                   break;
               case 4:
                   f.maxVovels();
                   break;
               default:
                   break;
           }
        }
        System.out.println("Running in Succession: " + (System.currentTimeMillis()-time) + " ms");
    }
}
