package lab7;

import java.io.File;

public class FileExplorer {

    public static void search(File f) {

        File[] tab = f.listFiles();
        for (File file1 : tab) {
            if (file1.isDirectory()) {
                System.out.println("- "+file1);
                search(file1);
            }

            else {
                System.out.println("\t+ " + file1);
            }
        }
    }


    public static void main(String[] args) {
        try {
            File f = new File("resources");
            search(f);
        } catch (Exception e) {
        }

    }
}
