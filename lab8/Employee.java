package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee implements Serializable, Comparable<Employee> {

    private int id;

    private Personal_Info employeeInfo;
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList <Career> employeeCareer = new ArrayList<>();
    private Cv employeeCv;

    private String sallary;

    public void getInfo() {
        System.out.println("=========================================");
        System.out.println("Employee Information:");
        System.out.println("id: " +id);
        System.out.println("Sallary: " +sallary);
        System.out.println("Personal Information: " +employeeInfo.toString());
        System.out.println("Career: " +employeeCareer.toString());
        System.out.println("CV: " +employeeCv.toString());
        System.out.println("=========================================\n");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId() {
        Scanner scanner = new Scanner(System.in);

        String inputId;

        do {
            System.out.print("Enter Employee's ID: ");
            inputId = scanner.next();
            if (RegexCheck.checkInt(inputId)) break;
            else System.out.println("Mistakes Were Made!");
        } while (true);


        this.id = Integer.valueOf(inputId);
    }


    public Personal_Info getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(Personal_Info employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public ArrayList<Career> getEmployeeCareer() {
        return employeeCareer;
    }

    public Cv getEmployeeCv() {
        return employeeCv;
    }

    public void setEmployeeCv(Cv employeeCv) {
        this.employeeCv = employeeCv;
    }

    public String getSallary() {
        return sallary;
    }

    public void setSallary() {

        Scanner scanner = new Scanner(System.in);
        String sallary;

        do {
            System.out.print("Enter Sallary: ");
            sallary = scanner.next();
            if (RegexCheck.checkInt(sallary)) break;

        } while (true);

        this.sallary = sallary;
    }

    public void addCareer(Career somecareer){

        employeeCareer.add(somecareer);

    }

    public static Employee createNewEmployee() {

        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee();

        employee.setId();

        employee.setEmployeeInfo(Personal_Info.createPersonalInfo());

        do{
            employee.getEmployeeCareer().add(Career.createCareer());
            System.out.print("Add New Carrer?(Y/N)");
            String repeat = scanner.next();

            if(repeat.equals("N")){
                break;
            }
        }while (true);

        employee.setEmployeeCv(Cv.createCv());

//        System.out.print("Enter Sallary: ");
        employee.setSallary();

        return employee;
    }

    public void setSallary(String sallary) {
        this.sallary = sallary;
    }

    @Override
    public String toString() {
        return "=========================================\n" +
                "Employee Information:" +
                "\nid: " + id +
                "\nemployeeInfo: " + employeeInfo +
                "\nemployeeCareer: " + employeeCareer +
                "\nemployeeCv: " + employeeCv +
                "\nsallary: " + sallary +
                "\n=========================================";
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id, o.id);
        }
}