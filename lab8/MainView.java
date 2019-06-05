package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class MainView extends BorderPane {
    private Stage stage;
    private Human_Resourse hr;

    private Text header;
    private VBox buttons;

    private Button createButton;
    private Button showButton;
    private Button sortButton;
    private Button loadButton;
    private Button saveButton;

    private FileChooser fileChooser = new FileChooser();

    private VBox tablebox;
    private ListView<Employee> table;
    private ObservableList<Employee> data;

    private VBox addBox;


    public MainView(Stage stage) {
        this.stage = stage;
        initElements();
        placeElements();
        setActions();
    }

    private void initElements() {
        hr = new Human_Resourse();

        header = new Text("EMPLOYEE MANAGER");
        header.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        header.setFill(Color.CADETBLUE);
        header.setStroke(Color.CADETBLUE);

        buttons = new VBox();
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setSpacing(10);

        //CREATE BUTTON
        createButton = new Button("ADD EMPLOYEE");
        createButton.setPrefWidth(150);
        showButton = new Button("SHOW EMPLOYEES");
        showButton.setPrefWidth(150);
        sortButton = new Button("SORT EMPLOYEES");
        sortButton.setPrefWidth(150);
        loadButton = new Button("LOAD DATA");
        loadButton.setPrefWidth(150);
        saveButton = new Button("SAVE DATA");
        saveButton.setPrefWidth(150);

//        //FOR SHOW EMPLOYEES
        tablebox = new VBox();
        table = new ListView<Employee>();

        //for add employee
        addBox = new VBox();

    }

    private void placeElements() {
        this.setTop(header);
        this.setLeft(buttons);
        buttons.getChildren().addAll(showButton, createButton, sortButton, loadButton, saveButton);


    }

    private void setActions() {

        loadButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        File file = fileChooser.showOpenDialog(stage);
                        if (file != null) {
                            hr = Human_Resourse.loadEmployees(file);


                        }
                    }
                });

        showButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        showEmployeesView();

                    }
                });

        createButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        createEmployeeView();

                    }
                });

        sortButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        sortEmployeesView();

                    }
                });

//        saveButton.setOnAction(
//                new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(final ActionEvent e) {
//                        File file = fileChooser.showOpenDialog(stage);
//                        if (file != null) {
//                            hr = Human_Resourse.saveEmployees(file);
//
//
//                        }
//                    }
//                });

    }

    private void showEmployeesView() {
        tablebox.getChildren().clear();
        data = FXCollections.observableArrayList(hr.getEmployees());
        table = new ListView<>(data);
        table.getFocusModel().focus(1);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().selectIndices(1, 2);
        table.getFocusModel().focus(1);
        tablebox.getChildren().add(table);
        this.setCenter(tablebox);

    }

    private void sortEmployeesView() {
        data = FXCollections.observableArrayList(hr.getEmployees());
        Collections.sort(data);

        tablebox.getChildren().clear();
        table = new ListView<>(data);
        table.getFocusModel().focus(1);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().selectIndices(1, 2);
        table.getFocusModel().focus(1);
        tablebox.getChildren().removeAll(); //!!!
        tablebox.getChildren().add(table);
        this.setCenter(tablebox);

    }

    public void createEmployeeView(){

        data = FXCollections.observableArrayList(hr.getEmployees());

        final TextField addID = new TextField();
        addID.setPromptText("Enter ID");
        addID.setMaxWidth(200);

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("Enter First Name");
        addFirstName.setMaxWidth(200);

        final TextField addMiddleName = new TextField();
        addMiddleName.setPromptText("Enter Middle Name");
        addMiddleName.setMaxWidth(200);

        final TextField addSecondName = new TextField();
        addSecondName.setPromptText("Enter Second Name");
        addSecondName.setMaxWidth(200);

        final TextField addEducation = new TextField();
        addEducation.setPromptText("Enter Education");
        addEducation.setMaxWidth(200);

        final TextField addSignDate = new TextField();
        addSignDate.setPromptText("Enter Sign Date");
        addSignDate.setMaxWidth(200);

        final TextField addOccupation = new TextField();
        addOccupation.setPromptText("Enter Occupation");
        addOccupation.setMaxWidth(200);

        final TextField addDepartment = new TextField();
        addDepartment.setPromptText("Enter Department");
        addDepartment.setMaxWidth(200);

        final TextField addVirtue = new TextField();
        addVirtue.setPromptText("Enter Virtue");
        addVirtue.setMaxWidth(200);

        final TextField addRate = new TextField();
        addRate.setPromptText("Enter Rate");
        addRate.setMaxWidth(200);

        final TextField addSalary = new TextField();
        addSalary.setPromptText("Enter Salary");
        addSalary.setMaxWidth(200);

        addBox.getChildren().addAll(addID, addFirstName, addMiddleName, addSecondName, addEducation, addSignDate,
                addOccupation, addDepartment, addVirtue, addRate, addSalary);
        this.setCenter(addBox);


        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(addID.getText()));

                Personal_Info pi = new Personal_Info();
                pi.setFirstName(addFirstName.getText());
                pi.setMiddleName(addMiddleName.getText());
                pi.setSecondName(addSecondName.getText());
                pi.setEducation(addEducation.getText());
                employee.setEmployeeInfo(pi);

                Career cr = new Career();
                cr.setSignDate(addSignDate.getText());
                cr.setOccupation(addOccupation.getText());
                cr.setDepartment(addDepartment.getText());
                employee.addCareer(cr);

                Cv cv = new Cv();
                cv.addVirtue(addVirtue.getText(), Integer.parseInt(addRate.getText()));
                employee.setEmployeeCv(cv);

                employee.setSallary(addSalary.getText());
                data.add(employee);
                hr.addNewEmployee(employee);
            }
        });

        addBox.getChildren().add(addButton);

    }
}
