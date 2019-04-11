package perkins.JSON;

import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;;
import java.util.Scanner;



public class Operations
{
    public static JSONArray ReadJsonFromFile(string file)
    {
        try {
            input = new Scanner(file);
            
            StringBuilder jsonString = new StringBuilder();
            while (input.hasNextLine())
            {
                jsonString.append(input.nextLine());

            }
                JSONParser jsonParser = new JSONParser(source, global, dualFields)


            )
        } catch (FileNotFoundException e) {
            //TODO: handle exception
        }
        
    }
    public static boolean SaveJsonToFile(string Json)
    {

    }

}