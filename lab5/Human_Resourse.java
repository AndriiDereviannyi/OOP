package lab5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human_Resourse implements Serializable {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Employee> employees = new ArrayList<>();

    public void addNewEmployee(Employee emp) {
        employees.add(emp);
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }


    public static Human_Resourse loadEmployees() {
        Human_Resourse hr = null;

        File userFile;

        do {
            String filePath = FolderSelector.doFile();
            userFile = new File(filePath);
            if (userFile.getName().substring(userFile.getName().length() - 4).equals(".xml")) {
                break;
            } else {
                System.out.println("Wrong File");
            }

        } while (true);


        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(userFile));
            hr = xmlMapper.readValue(xml, Human_Resourse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hr;
    }

    public static void saveEmployees(Human_Resourse hr) {
        File userFile;

        do {
            userFile = new File(FolderSelector.doFile());
            if (userFile.getName().substring(userFile.getName().length() - 4).equals(".xml"))
                break;

        } while (true);

        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(userFile, hr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void showEmployees() {

        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).getInfo();
        }
    }

    public Employee getEmployeeByID(int id) {

        Employee someEmp = null;

        for (int i = 0; i < employees.size(); i++) {

            if (id == employees.get(i).getId()) {
                someEmp = employees.get(i);
                break;
            }
        }

        if (someEmp == null) {
            System.out.println("This Empolyee Wasn't Found");
        }

        someEmp.getInfo();

        return someEmp;
    }

    public static int selectEmployeeID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        return id;
    }

    public void deleteEmployeeByID(int id) {

        Employee someEmp = null;

        for (int i = 0; i < employees.size(); i++) {

            if (id == employees.get(i).getId()) {
                someEmp = employees.remove(i);
                break;
            }
        }
        if (someEmp == null) {
            System.out.println("This Empolyee Wasn't Found");
        }

        System.out.println("Done");
    }

    public static String doFile() {
        Scanner in = new Scanner(System.in);

        String pathToFile = "D://";
        String userChoice;

        while (true) {
            File dir = new File(pathToFile);
            if (dir.isDirectory()) {
                if (dir.listFiles() != null) {
                    for (File item : dir.listFiles()) {
                        if (item.isDirectory()) {
                            System.out.println(item.getName() + "\t (folder)");
                        } else {
                            System.out.println(item.getName() + "\t (file)");
                        }
                    }
                }

            }

            userChoice = in.nextLine();

            if (userChoice.equals("..")) {
                char[] c = pathToFile.toCharArray();
                for (int i = c.length - 3; i > -1; i--) {
                    System.out.print(c[i]);
                    if (c[i] == '/') {
                        int k = i + 1;
                        pathToFile = "";
                        for (int j = 0; j < k; j++) {
                            pathToFile += c[j];
                        }
                        i = -1;
                    }
                }
            } else {
                String extension = userChoice.substring(userChoice.length() - 4);
                pathToFile += userChoice;
                if (extension.equals(".xml")) {
                    return pathToFile;
                } else if (extension.equals(".out")) {
                    return pathToFile;
                } else {
                    pathToFile += "/";
                }
            }
            System.out.println();
            System.out.println(pathToFile);
        }

    }
}