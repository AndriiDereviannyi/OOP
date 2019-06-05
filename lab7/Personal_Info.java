package lab7;

import java.io.Serializable;
import java.util.Scanner;

public class Personal_Info implements Serializable {

    private String firstName;
    private String secondName;
    private String middleName;
    private String educatiuon;

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", educatiuon='" + educatiuon;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setFirstName() {
        Scanner scanner = new Scanner(System.in);
        String firstname;

        do {
            System.out.print("Enter Fistname: ");
            firstname = scanner.next();
            if (RegexCheck.checkString(firstname)) break;
            else System.out.println("Mistakes Were Made");
        } while (true);

        this.firstName = firstname;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public void setSecondName() {

        Scanner scanner = new Scanner(System.in);
        String secondname;

        do {
            System.out.print("Enter Secondname: ");
            secondname = scanner.next();
            if (RegexCheck.checkString(secondname)) break;
            else System.out.println("Mistakes Were Made");
        } while (true);

        this.secondName = secondname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName() {

        Scanner scanner = new Scanner(System.in);
        String middlename;

        do {
            System.out.print("Enter Middlename: ");
            middlename = scanner.next();
            if (RegexCheck.checkString(middlename)) break;
            else System.out.println("Mistakes Were Made");
        } while (true);

        this.middleName = middlename;
    }

    public String getEducatiuon() {
        return educatiuon;
    }

    public void setEducation() {

        Scanner scanner = new Scanner(System.in);
        String education;

        do {
            System.out.print("Enter Education: ");
            education = scanner.next();
            if (RegexCheck.checkString(education)) break;
            else System.out.println("Mistakes Were Made");
        } while (true);

        this.educatiuon = education;
    }

    public static Personal_Info createPersonalInfo() {

        Scanner scanner = new Scanner(System.in);

        Personal_Info pi = new Personal_Info();

//        System.out.print("Enter Fistname: ");
//        String firstname = scanner.next();
        pi.setFirstName();

//        System.out.print("Enter Middlename: ");
//        String middlename = scanner.next();
        pi.setMiddleName();

//        System.out.print("Enter Lastname: ");
//        String lastname = scanner.next();
        pi.setSecondName();

//        System.out.print("Enter Education: ");
//        String education = scanner.next();
        pi.setEducation();

        return pi;
    }

//    public void validateData(){
//
//        String data = "12389";
//        data.matches()
//
//    }
}
