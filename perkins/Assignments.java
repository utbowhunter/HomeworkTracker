package perkins;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.*;

public class Assignments {

    public static ArrayList<Assignment> List = new ArrayList<Assignment>();

    public static Boolean Add(Assignment assignment) {
        List.add(assignment);

        return true;
    }

    public static Boolean LoadAssignmentListFromJSON(String file) {
        JSONArray jsonArray = new JSONArray();
        try {

            boolean exists = new File(file).exists();

            if (exists) {
                jsonArray = perkins.JSON.Operations.ReadJsonFromFile(file, "Assignments");

                if (jsonArray != null) {
                    for (Object a : jsonArray) {
                        JSONObject jsonObj = (JSONObject) a;
                        Assignment newAssignment = new Assignment();

                        newAssignment.Name = (String) jsonObj.get("Name");
                        newAssignment.ClassName = (String) jsonObj.get("ClassName");
                        newAssignment.AssignedDate = (String) jsonObj.get("AssignedDate");
                        newAssignment.DueDate = (String) jsonObj.get("DueDate");
                        newAssignment.Completed = Boolean.parseBoolean((String) jsonObj.get("Complete"));

                        Assignments.Add(newAssignment);
                    }
                }
            }
        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

        return true;

    }

    public static Boolean WriteToJSONFile(ArrayList List) {
        JSONArray assignments = new JSONArray();
        JSONObject objAssign = new JSONObject();

        for (Assignment assign : Assignments.List) {
            JSONObject jsonAssign = new JSONObject();

            // ***** Build the assignment object
            jsonAssign.put("Name", assign.Name);
            jsonAssign.put("ClassName", assign.ClassName);
            jsonAssign.put("AssignedDate", assign.AssignedDate);
            jsonAssign.put("DueDate", assign.DueDate);
            jsonAssign.put("Completed", assign.Completed);

            // ***** Add the Object to the Array
            assignments.add(jsonAssign);
        }

        objAssign.put("Assignments", assignments);

        // ***** Write the JSONArray to file
        try {
            FileWriter file = new FileWriter("data/homework2.json");
            file.write(objAssign.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;

    }

}