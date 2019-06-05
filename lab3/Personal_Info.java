package lab3;

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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEducatiuon() {
        return educatiuon;
    }

    public void setEducation(String education) {
        this.educatiuon = education;
    }

    public static Personal_Info createPersonalInfo() {

        Scanner scanner = new Scanner(System.in);

        Personal_Info pi = new Personal_Info();

        System.out.print("Enter Fistname: ");
        String firstname = scanner.next();
        pi.setFirstName(firstname);

        System.out.print("Enter Middlename: ");
        String middlename = scanner.next();
        pi.setMiddleName(middlename);

        System.out.print("Enter Lastname: ");
        String lastname = scanner.next();
        pi.setSecondName(lastname);

        System.out.print("Enter Education: ");
        String education = scanner.next();
        pi.setEducation(education);

        return pi;
    }

//    public void validateData(){
//
//        String data = "12389";
//        data.matches()
//
//    }
}
