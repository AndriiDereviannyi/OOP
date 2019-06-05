package lab4;

import lab3.Career;
import lab3.Cv;
import lab3.Employee;
import lab3.Personal_Info;

public class AutomationForThePeople {

    private static Human_Resourse_v2 HR = new Human_Resourse_v2();

    public static void auto() {


        System.out.println("1 - Adding New Employee");
        Personal_Info someInfo = new Personal_Info();
        someInfo.setFirstName("Андрій");
        someInfo.setMiddleName("Андрійович");
        someInfo.setSecondName("Деревянний");
        someInfo.setEducation("НУЛП");

        Career someCareer = new Career();
        someCareer.setSignDate("22-05-2019");
        someCareer.setDepartment("AI");
        someCareer.setOccupation("Junior");

        Cv someCv = new Cv();
        someCv.addVirtue("Great", 10);

        Employee someEmployee = new Employee();

        someEmployee.setId(1);
        someEmployee.setEmployeeInfo(someInfo);
        someEmployee.addCareer(someCareer);
        someEmployee.setEmployeeCv(someCv);
        someEmployee.setSallary(10000);

        HR.addNewEmployee(someEmployee);

        System.out.println("\tEmployee Was Added");

        System.out.println("\n2 - Showing Employees");
        HR.showEmployees();

        System.out.println("\n3 - Search For Employee(ID: 1)");
        HR.getEmployeeByID(1);

        System.out.println("\n4 - Serializing...");
        ListContainer.serialize(HR.getEmployees() ,"autosave.ser");
        System.out.println("\tDone");

        System.out.println("\n5 - Deleting Employee");
        HR.deleteEmployeeByID(1);
        System.out.println("\tDone");

        System.out.println("\n6 - Employees:");
        HR.showEmployees();

        System.out.println("\n7 - Deserializing...");
        HR.setEmployees(ListContainer.deserialize("autosave.ser"));
        System.out.println("\tDone");

        System.out.println("\n8 - Employees:");
        HR.showEmployees();
    }
}
