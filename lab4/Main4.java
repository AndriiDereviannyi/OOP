package lab4;

import lab3.Employee;
import lab3.Human_Resourse;
import lab3.ParametresLab3;

import java.util.Collections;
import java.util.Scanner;

public class Main4 {

    private static Human_Resourse_v2 HR = new Human_Resourse_v2();

    public static void main(String[] args) {

//        ParametresLab4 help = new ParametresLab4();
//        if (args.length>0) {
//            if (args[0].equals("-h") || args[0].equals("-help") || args[1].equals("-h") || args[1].equals("-help")) {
//                help.help();
//            }
//        }

        AutomationForThePeople auto = new AutomationForThePeople();
        if (args.length > 0) {
            if (args[0].equals("-a") || args[0].equals("-auto") || args[1].equals("-a") || args[1].equals("-auto")) {
                auto.auto();
            }
        } else {

            showMenu();

            do {
                int menu = userChoice();
                doAction(menu);
            } while (true);
        }
    }

    public static void showMenu(){

        System.out.println("\nCommands:");
        System.out.println("1 - Load File");
        System.out.println("2 - Show Employees");
        System.out.println("3 - Search Employee by ID");
        System.out.println("4 - Add New Employee");
        System.out.println("5 - Sort Employees");
        System.out.println("6 - Delete Employee by ID");
        System.out.println("7 - Save Changes");
        System.out.println("0 - Exit");
    }

    public static int userChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Menu Entry: ");
        int userChoice = scanner.nextInt();

        return userChoice;
    }




    public static void doAction(int menuNumber){
        switch(menuNumber){

            case 1: HR.loadFromXML(); break;
            case 2: HR.showEmployees(); break;
            case 3: HR.getEmployeeByID(Human_Resourse_v2.selectEmployeeID()); break;
            case 4: HR.addNewEmployee(Employee.createNewEmployee()); break;
            case 5: Collections.sort(HR.getEmployees()); break;
            case 6: HR.deleteEmployeeByID(Human_Resourse_v2.selectEmployeeID()); break;
            case 7: HR.saveToXML(); break;
            case 0:
                System.exit(0);
            default:
                System.out.println("\nWrong Entry");
        }
    }
}