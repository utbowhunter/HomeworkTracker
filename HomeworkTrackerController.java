import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import perkins.Assignment;
import perkins.Assignments;
import javafx.event.ActionEvent;
import javafx.fxml.*;

public class HomeworkTrackerController implements Initializable {
    
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonModify;    
    @FXML
    private Button buttonDelete;
    
    @FXML
    private TextField textBoxAssignmentName;
    @FXML
    private TextField textBoxCourseName;

    @FXML
    private DatePicker datetimeAssignDate;
    @FXML
    private DatePicker datetimeDueDate;
    @FXML
    private CheckBox checkboxCompleted;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }
    @FXML
    public void handleSaveButtonClick(ActionEvent event)
    {
        Assignment assignment = new Assignment();

        // ***** Loadup the object with values from the screen
        assignment.Name = textBoxAssignmentName.getText();
        assignment.ClassName = textBoxCourseName.getText();
        assignment.AssignedDate = datetimeAssignDate.getPromptText();
        assignment.DueDate = datetimeDueDate.getPromptText();

        if (checkboxCompleted.isSelected())
        {assignment.Completed = true;}
        else
        {assignment.Completed = false;}

        Assignments.List.add(assignment);

        // ***** Add to the grid

        
//
    }

   
    

}