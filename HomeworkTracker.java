
import perkins.Assignment;
import perkins.Assignments;
import perkins.JSON.Operations.*;
import org.json.simple.JSONArray;

class HomeworkTracker {
    public static void main(String[] args) {
        
        JSONArray jsonArray = new JSONArray();
        try 
        {
            String file = "data/homework.json";
            Assignments.LoadAssignmentListFromJSON(file);

            for (Assignment var : Assignments.List) {
                
                System.out.println("Name: " + var.Name);
                System.out.println("Class Name: " + var.ClassName);
                System.out.println("Due Date: " + var.DueDate);
            }
        } 
        catch (Exception e) {
            //TODO: handle exception
        }
        
       
    }
}