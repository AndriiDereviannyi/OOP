package lab4;

import java.io.File;
import java.util.Scanner;

public class FolderSelector {

    public static String doFile() {
        Scanner in = new Scanner(System.in);

        String pathToFile = "D://";
        String userChoice;

        while (true) {
            File dir = new File(pathToFile);
            if (dir.isDirectory()) {
                if (dir.listFiles() != null) {
                    for (File item : dir.listFiles()) {
                        if (item.isDirectory()) {
                            System.out.println(item.getName() + "\t (folder)");
                        } else {
                            System.out.println(item.getName() + "\t (file)");
                        }
                    }
                }

            }

            userChoice = in.nextLine();

            if (userChoice.equals("..")) {
                char[] c = pathToFile.toCharArray();
                for (int i = c.length - 3; i > -1; i--) {
                    System.out.print(c[i]);
                    if (c[i] == '/') {
                        int k = i + 1;
                        pathToFile = "";
                        for (int j = 0; j < k; j++) {
                            pathToFile += c[j];
                        }
                        i = -1;
                    }
                }
            } else {
                String extension = userChoice.substring(userChoice.length() - 4);
                pathToFile += userChoice;
                if (extension.equals(".xml")) {
                    return pathToFile;
                } else if (extension.equals(".out")) {
                    return pathToFile;
                } else {
                    pathToFile += "//";
                }
            }
            System.out.println();
            System.out.println(pathToFile);
        }

    }
}
