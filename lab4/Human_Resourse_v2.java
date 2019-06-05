package lab4;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lab3.Employee;

import java.util.Scanner;

public class Human_Resourse_v2 {

    @JacksonXmlElementWrapper(useWrapping = false)
    private ListContainer<Employee> employees = new ListContainer<>();

    public void addNewEmployee(Employee emp) {
        employees.insertLast(emp);
    }

    public void showEmployees() {

        employees.showContainer();
    }

    public ListContainer<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ListContainer<Employee> employees) {
        this.employees = employees;
    }

    public void getEmployeeByID(int id) {

        Employee someEmp = null;

        for (int i = 0; i < employees.size(); i++) {

            if (id == employees.findByIndex(i).getId()) {
                someEmp = employees.findByIndex(i);
                break;
            }
        }

        if (someEmp == null) {
            System.out.println("This Empolyee Wasn't Found");
        } else {
            someEmp.getInfo();
        }
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

            if (id == employees.findByIndex(i).getId()) {
                someEmp = employees.deleteByIndex(i);

                break;
            }
        }
//        if (someEmp == null) {
//            System.out.println("This Empolyee Wasn't Found");
//        }
        System.out.println("Done");

    }

    public void loadFromXML() {

        ListContainer<Employee> data = ListContainer.loadFromXML();

        if (data != null)
            this.setEmployees(data);

        else
            this.setEmployees(new ListContainer<Employee>());

    }

    public void saveToXML() {

        ListContainer.savetoXML(this.getEmployees());

    }

//    public static Human_Resourse_v2 loadEmployees() {
//        Human_Resourse_v2 hr = null;
//
//        File userFile;
//
//        do {
//            String filePath = FolderSelector.doFile();
//            userFile = new File(filePath);
//            if (userFile.getName().substring(userFile.getName().length() - 4).equals(".xml")) {
//                break;
//            } else {
//                System.out.println("Wrong File");
//            }
//
//        } while (true);
//
//
//        try {
//            XmlMapper xmlMapper = new XmlMapper();
//            String xml = inputStreamToString(new FileInputStream(userFile));
//            hr = xmlMapper.readValue(xml, Human_Resourse_v2.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return hr;
//
//
//    }
//
//    public static void saveEmployees(Human_Resourse_v2 hr) {
//        File userFile;
//
//        do {
//            userFile = new File(FolderSelector.doFile());
//            if (userFile.getName().substring(userFile.getName().length() - 4).equals(".xml")) {
//                break;
//            }
//
//        } while (true);
//
//        try {
//            XmlMapper xmlMapper = new XmlMapper();
//            xmlMapper.writeValue(userFile, hr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String inputStreamToString(InputStream is) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        String line;
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        while ((line = br.readLine()) != null) {
//            sb.append(line);
//        }
//        br.close();
//        return sb.toString();
//    }
}
