package lab6;


import java.util.Arrays;

public class Actions extends Thread{

    Container container = Main6.container;
    int z=0;
    Actions(int z){
        this.z = z;
    }
    Actions(){}

    public void run(){
        if (z==1){
            getMin();
        }else if (z==2){
            getMax();
        }else if (z==3){
            maxConsonants();
        }else if (z==4){
            maxVovels();
        }
    }

    public void getMin(){
        String s = null;
        int l=1000;
        for (int i=0;i<container.size();i++){
            String wrd = container.get(i);
            if (wrd.length()<l){
                l=wrd.length();
                s=wrd;
            }
        }
        System.out.println("The Shortest Word: "+s);
    }
    public  void getMax() {
        String s = null;
        int l = 0;
        for (int i = 0; i < container.size(); i++) {
            String wrd = container.get(i);
            if (wrd.length() > l) {
                l = wrd.length();
                s = wrd;
            }
        }
        System.out.println("The Longest Word: " + s);
    }


    public void maxVovels() {
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};

        String res=null;
        int con=0;
        for (int i=0;i<container.size();i++){
            char[] word = container.get(i).toCharArray();
            int c = 0;
            for (int j=0;j<word.length;j++){
                if (Arrays.binarySearch(vowel, word[j])>=0 || Arrays.binarySearch(vowel, (char)(word[j]+32))>=0){
                    c++;
                }
            }

            if (c>con){
                res = String.valueOf(word);
                con = c;
            }
        }
        System.out.println("The Word with The Most Vowels is '" + res + "': " + con);
    }
    public void maxConsonants(){

        char[] consonants =  {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};

        String res=null;
        int con=0;
        for (int i=0;i<container.size();i++){
            char[] word = container.get(i).toCharArray();
            int c=0;
            for (int j=0;j<word.length;j++){
                if (Arrays.binarySearch(consonants, word[j])>=0 || Arrays.binarySearch(consonants, (char)(word[j]+32))>=0){
                    c++;
                }
            }

            if (c>con){
                res = String.valueOf(word);
                con = c;
            }
        }
        System.out.println("The Word with The Most Consonants is '" + res + "': " + con);
    }
}

