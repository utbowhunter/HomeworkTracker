
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

import perkins.Assignment;
import perkins.Assignments;
import perkins.Settings;
import perkins.JSON.Operations.*;

import java.util.Set;

import org.json.simple.JSONArray;

public class HomeworkTracker extends Application {
    public static void main(String[] args) {

        try {
         
            launch(args);
            // Boolean retVal = Assignments.WriteToJSONFile(Assignments.List);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            LoadSettings();

            LoadData();

            Parent root = FXMLLoader.load(getClass().getResource("HomeworkTracker.fxml"));
            primaryStage.setTitle("Homework Tracker");
            primaryStage.setScene(new Scene(root, 850, 600));
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * private static Save() { Assignment assignment = new Assignment();
     * 
     * assignment.name = textboxName.text;
     * 
     * 
     * Assignments.List.add(assignment);
     * 
     * // Save the Assignment.List to file
     * 
     * 
     * }
     */
    private static TableView CreateTableView() {

        TableView tableView = new TableView();

        // **** Assignment Name Column
        TableColumn<Assignment, String> nameColumn = new TableColumn<>("Assignment Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellFactory(new PropertyValueFactory("Name"));
        // **** Assignment Name Column
        TableColumn<Assignment, String> classNameColumn = new TableColumn<>("Class Name");
        classNameColumn.setMinWidth(100);
        classNameColumn.setCellFactory(new PropertyValueFactory("ClassName"));
        // **** Assignment Name Column
        TableColumn<Assignment, String> assignDateColumn = new TableColumn<>("Assigned Date");
        assignDateColumn.setMinWidth(25);
        assignDateColumn.setCellFactory(new PropertyValueFactory("AssignedDate"));
        // **** Assignment Name Column
        TableColumn<Assignment, String> dueDateColumn = new TableColumn<>("DueDate");
        dueDateColumn.setMinWidth(25);
        dueDateColumn.setCellFactory(new PropertyValueFactory("DueDate"));
        // **** Assignment Name Column
        TableColumn<Assignment, String> completeColumn = new TableColumn<>("Completed");
        completeColumn.setMinWidth(10);
        completeColumn.setCellFactory(new PropertyValueFactory("Completed"));

        tableView.getColumns().addAll(nameColumn, classNameColumn, assignDateColumn, dueDateColumn, completeColumn);

        return tableView;
    }

    private static ObservableList<Assignment> GetData() {
        ObservableList<Assignment> assignments = FXCollections.observableArrayList();

        for (Assignment assignment : Assignments.List) {
            assignments.add(assignment);
        }

        return assignments;
    }

    public static void LoadData() {
        // ***** Retrieve the data file location from the settings collections
        String file = Settings.RetrieveSettingValueByKey("datafile"); // "data/homework.json";

        // ***** Load the data into the Data Model
        Assignments.LoadAssignmentListFromJSON(file);
    }

    public static void LoadSettings() {

        // ***** Retireve the settings from the settings file
        String settingsFile = "data/settings.json";
        Settings.LoadSettingsFromJSONFile(settingsFile);
    }
}