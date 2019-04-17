
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class HomeworkTracker  extends Application {
    public static void main(String[] args) {
    

        try 
        {
           LoadSettings();

           LoadData();

           launch(args);
            //Boolean retVal = Assignments.WriteToJSONFile(Assignments.List);

        } 
        catch (Exception e) {
            //TODO: handle exception
        }
        
       
    }
        @Override
        public void start(Stage primaryStage) throws Exception {
            try {
                GridPane grid= new GridPane();
                Scene scene = new Scene(grid,800,400);
                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setTitle("Assignment Tracker");
                grid.setHgap(10);
                grid.setVgap(10);
                primaryStage.setScene(scene);
                primaryStage.show();
        
                Label a= new Label("Assignment");
                grid.add(a, 1, 0);
                
                TextField name=new TextField();
                name.setPromptText("Enter assignment name");
                GridPane.setConstraints(name,2,1);
                grid.getChildren().add(name);
            
                
                TextField course=new TextField();
                course.setPromptText("Enter course name");
                GridPane.setConstraints(course,2,2);
                grid.getChildren().add(course);
                
    
                DatePicker assignDate =new DatePicker();
                assignDate.setValue(LocalDate.now());
                GridPane.setConstraints(assignDate,2,4);
                grid.getChildren().add(assignDate);
                Label d= new Label("Assigned date:");
                grid.add(d, 2, 3);
                
                DatePicker dueDate =new DatePicker();
                dueDate.setValue(LocalDate.now());
                GridPane.setConstraints(dueDate,3,4);
                grid.getChildren().add(dueDate);
                Label p= new Label("Due date:");
                grid.add(p, 3, 3);
                
                /*Button save=new Button("Save");
                grid.add(save, 4, 4);
                save.setDisable(false);
                save.setOnAction(e->{
                    String name1= String.valueOf(name.getText());
                    String course1=String.valueOf(course.getText());
                    String main=System.out.println("Assignment"+ name1);
                    save.setText(main.toString());
                });
                */

                ObservableList<Assignment> data = GetData();

                TableView<Assignment> tableView = CreateTableView();
                tableView.setItems(data);

                grid.add(tableView, 4, 3);
            
    
            } catch(Exception e) {
                e.printStackTrace();
            }
    }
  
     private static TableView CreateTableView()
     {

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
     private static ObservableList<Assignment> GetData()
     {
         ObservableList<Assignment> assignments = FXCollections.observableArrayList();

        for (Assignment assignment : Assignments.List)
        {
            assignments.add(assignment);
        }

        return assignments;
     }
  
    private static void LoadData()
    {
        // ***** Retrieve the data file location from the settings collections          
        String file = Settings.RetrieveSettingValueByKey("datafile"); //"data/homework.json";

        // ***** Load the data into the Data Model
        Assignments.LoadAssignmentListFromJSON(file);
    }
    private static void LoadSettings(){

        // ***** Retireve the settings from the settings file 
        String settingsFile = "data/settings.json";
        Settings.LoadSettingsFromJSONFile(settingsFile);
    }
}