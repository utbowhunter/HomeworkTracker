
import perkins.Assignment;
import perkins.Assignments;
import perkins.Settings;
import perkins.JSON.Operations.*;

import java.util.Set;

import org.json.simple.JSONArray;

class HomeworkTracker {
    public static void main(String[] args) {
        
        //JSONArray jsonArray = new JSONArray();
        try 
        {
           LoadSettings();

           LoadData();

          //start ui configuation

            for (Assignment var : Assignments.List) {
                
               // System.out.println("Name: " + var.Name);
                //System.out.println("Class Name: " + var.ClassName);
                //System.out.println("Due Date: " + var.DueDate);
            }
            
        


            //Boolean retVal = Assignments.WriteToJSONFile(Assignments.List);

        } 
        catch (Exception e) {
            //TODO: handle exception
        }
        
       
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