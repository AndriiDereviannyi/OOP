package lab5;

//import java.io.File;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main5 implements Serializable {

    private static Human_Resourse HR = new Human_Resourse();

    public static void main(String[] args) {

        ParametresLab3 help = new ParametresLab3();
        if (args.length>0) {
            if (args[0].equals("-h") || args[0].equals("-help") || args[1].equals("-h") || args[1].equals("-help")) {
                help.help();
            }
        }

        showMenu();

        do{
            int menu = userChoice();
            doAction(menu);
        } while (true);
    }

    public static void showMenu(){

        System.out.println("\nCommands:");
        System.out.println("1 - Load File");
        System.out.println("2 - Show Employees");
        System.out.println("3 - Search Employee by ID");
        System.out.println("4 - Add New Employee");
        System.out.println("5 - Delete Employee by ID");
        System.out.println("6 - Save Changes");
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

            case 1: HR = Human_Resourse.loadEmployees(); break;
            case 2: HR.showEmployees(); break;
            case 3: HR.getEmployeeByID(Human_Resourse.selectEmployeeID()); break;
            case 4: HR.addNewEmployee(Employee.createNewEmployee()); break;
            case 5: HR.deleteEmployeeByID(Human_Resourse.selectEmployeeID()); break;
            case 6: Human_Resourse.saveEmployees(HR); break;
            case 0:
                System.exit(0);
            default:
                System.out.println("\nWrong Entry");
        }
    }
}