package lab3;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Career implements Serializable {

    private String signDate;
    private String occupation;
    private String Department;

    @Override
    public String toString() {
        return "Occupation{" +
                "signDate=" + signDate +
                ", occupation='" + occupation + '\'' +
                ", Department='" + Department + '\'' +
                '}';
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public static Career createCareer() {

        Scanner scanner = new Scanner(System.in);

        Career cr = new Career();

        System.out.print("\nEnter Signing Date(DD-MM-YYYY): ");
        cr.setSignDate(scanner.nextLine());

        System.out.print("Enter Occupation: ");
        cr.setOccupation(scanner.nextLine());

        System.out.print("Enter Department: ");
        cr.setDepartment(scanner.nextLine());

        return cr;
    }

}
