package lab5;

import java.io.File;
import java.util.Scanner;

public class Filego  {
    public String doFile() {
// определяем объект для каталога
        String s2 = "";
        Filego main = new Filego();
        Scanner in = new Scanner(System.in);
        String s = "D://";
        String s1;
        while (true) {
            File dir = new File(s);
            // если объект представляет каталог
            if (dir.isDirectory()) {
                // получаем все вложенные объекты в каталоге
                for (File item : dir.listFiles()) {

                    if (item.isDirectory()) {

                        System.out.println(item.getName() + "\t (folder)");
                    } else {

                        System.out.println(item.getName() + "\t (file)");
                    }
                }
            }
            s1 = in.nextLine();
            if(s1.equals("..")){
                char[] c = s.toCharArray();
                for (int i =c.length-3;i>-1;i--){
                    System.out.print(c[i]);
                    if (c[i] =='/') {
                      int k =i+1;
                      s="";
                      for (int j =0;j<k;j++){
                          s+=c[j];
                      }
                      i=-1;
                    }
                }
            }
            else {
                char[]c =s1.toCharArray();
                for (int i =c.length-4;i<c.length;i++){
                    s2+=c[i];
                }
                if(s2.equals(".xml")){
                    return s1;
                }
                else if (s2.equals(".out")){
                    return s1;
                }
                else {
                    s += s1 + "//";
                }
                s2="";
            }
            System.out.println();
            System.out.println(s);
        }

    }
}
