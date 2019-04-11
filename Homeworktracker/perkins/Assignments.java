import java.util.List;
import perkins.JSON.*;

public static class Assignments
{    
    public static List<Assignment> List;

    public static bool Add(Assignment assignment)
    {
        List.add(assignment);
    }
    public static LoadAssignmentListFromJSON(string file)
    {
        string jsonString = perkins.JSON.Operations.ReadJsonFromFile(file);
        

        
    }


}