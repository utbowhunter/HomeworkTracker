package perkins.JSON;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Operations
{
    public static JSONArray ReadJsonFromFile(String file, String Heading) throws Exception
    {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();

        try {

                BufferedReader reader = new BufferedReader(new FileReader(file));
                                
                // parse the JSON file into an object
                Object object = jsonParser.parse(reader);
                //Object object = jsonParser.parse(new FileReader(file));

                // convert Object to JSONObject    
                JSONObject jsonObject = (JSONObject)object;

                jsonArray = (JSONArray)jsonObject.get(Heading);

        
        } 
        catch (Exception e)
        {
            System.out.println(e);
            throw(e);
            
        }
       
        
        return jsonArray;
    }
    public static boolean SaveJsonToFile(String Json)
    {


        return true;
    }

}