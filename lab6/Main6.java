package lab6;


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main6 {

    public static Container container = new Container();
    public static Menu menu = new Menu();

    public static void main(String args[]){

        ParametresLab6 help = new ParametresLab6();
        if (args.length>0) {
            if (args[0].equals("-h") || args[0].equals("-help") || args[1].equals("-h") || args[1].equals("-help")) {
                help.help();
            }
        }


        loadFile();

        while (true){
            try {
                menu.ptintMainMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadFile(){

        try {
            FileReader fileReader = new FileReader("D:\\Andy\\IDEA\\file.txt");
            Scanner sc = new Scanner(fileReader);
            while (sc.hasNextLine()) {
                Main6.container.add(sc.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Data Was Loaded");
    }
}