package lab5;

import java.io.Serializable;
import java.util.Scanner;

public class Career implements Serializable {

    private String signDate;
    private String occupation;
    private String department;

    @Override
    public String toString() {
        return "Occupation{" +
                "signDate=" + signDate +
                ", occupation='" + occupation + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate() {
        Scanner scanner = new Scanner(System.in);

        String signDate;

        do {
            System.out.print("\nEnter Signing Date(DD-MM-YYYY): ");
            signDate = scanner.next();
            if (RegexCheck.checkDate(signDate)) break;
            else System.out.println("Mistakes Were Made!");
        } while (true);

        this.signDate = signDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation() {

        Scanner scanner = new Scanner(System.in);

        String occupation;

        do {
            System.out.print("Enter Occupation: ");
            occupation = scanner.next();
            if (RegexCheck.checkString(occupation)) break;
            else System.out.println("Mistakes Were Made!");
        } while (true);

        this.occupation = occupation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment() {

        Scanner scanner = new Scanner(System.in);

        String department;

        do {
            System.out.print("Enter Department: ");
            department = scanner.next();
            if (RegexCheck.checkString(department)) break;
            else System.out.println("Mistakes Were Made!");
        } while (true);

        this.department = department;
    }

    public static Career createCareer() {

        Scanner scanner = new Scanner(System.in);

        Career cr = new Career();

//        System.out.print("\nEnter Signing Date(DD-MM-YYYY): ");
        cr.setSignDate();

//        System.out.print("Enter Occupation: ");
        cr.setOccupation();

//        System.out.print("Enter Department: ");
        cr.setDepartment();

        return cr;
    }

}
