package perkins;

import java.util.*;
import org.json.simple.*;

public class Assignments
{   
     
    public static ArrayList<Assignment> List = new ArrayList<Assignment>();

    public static Boolean Add(Assignment assignment)
    {
        List.add(assignment);

        return true;
    }
    public static Boolean LoadAssignmentListFromJSON(String file)
    {
        JSONArray jsonArray = new JSONArray();
        try 
        {
            jsonArray = perkins.JSON.Operations.ReadJsonFromFile(file); 
            
            for (Object a : jsonArray)
            {
                JSONObject jsonObj = (JSONObject)a;
                Assignment newAssignment = new Assignment();

                newAssignment.Name = (String) jsonObj.get("Name");
                newAssignment.ClassName = (String) jsonObj.get("ClassName");
                newAssignment.AssignedDate = (String) jsonObj.get("AssignedDate");
                newAssignment.DueDate = (String) jsonObj.get("DueDate");
                newAssignment.Completed = Boolean.parseBoolean((String)jsonObj.get("Complete"));

                Assignments.Add(newAssignment);
            }
        } catch (Exception e) {

            System.out.println(e);
            return false;
            
        }
        
        

        return true;
        
    }


}