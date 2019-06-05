package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cv implements Serializable {
    @JacksonXmlElementWrapper(useWrapping = false)
    private Map<String, Integer> virtuesAndRate = new HashMap<>();

    public Map<String, Integer> getVirtuesAndRate() {
        return virtuesAndRate;
    }

    public void addVirtue(String virtue, int mark){

        virtuesAndRate.put(virtue, mark);

    }

    public static Cv createCv(){

        Scanner scanner = new Scanner(System.in);

        Cv cv = new Cv();

        do {
            do {
                System.out.print("\nEnter Virtue Name: ");
                String virtue = scanner.next();


                System.out.print("Enter Rate(1...10): ");
                String rate = String.valueOf(scanner.nextInt());
                if (RegexCheck.checkString(virtue) && RegexCheck.checkInt(rate)) {
                    cv.getVirtuesAndRate().put(virtue, Integer.valueOf(rate));
                    break;
                }
            }
            while (true);

            System.out.print("Add More Evaluations?(Y/N)");
            String repeat = scanner.next();

            if(repeat.equals("N")){
                break;
            }
        } while (true);

        return cv;
    }


    @Override
    public String toString() {
        return "CV{" +
                "virtuesAndRate=" + virtuesAndRate +
                '}';
    }
}
