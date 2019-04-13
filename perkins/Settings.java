package perkins;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.simple.*;


public class Settings {

    public static Hashtable<String, String> settings = new Hashtable<String, String>();

    public static Boolean LoadSettingsFromJSONFile(String file) {
        JSONArray jsonArray = new JSONArray();
        try {

            boolean exists = new File(file).exists();
            if (exists) {

                jsonArray = perkins.JSON.Operations.ReadJsonFromFile(file, "Settings");

                for (Object a : jsonArray) {
                    JSONObject jsonObj = (JSONObject) a;

                    jsonObj.keySet().forEach(keyStr -> {
                        System.out.println("key: " + keyStr);

                        Object keyValue = jsonObj.get(keyStr);

                        System.out.println("key: " + keyStr + " value: " + keyValue);

                        settings.put(keyStr.toString(), keyValue.toString());

                    });
                }
            }
            else
            {
                throw new Exception("Settings file not found ... setup required!");
            }        
        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

        return true;

    }

    public static Boolean WriteSettingsToJSONFile() {
        JSONArray settingsArray = new JSONArray();
        JSONObject objAssign = new JSONObject();

        // Get a set of all the entries (key - value pairs) contained in the Hashtable
        Set entrySet = settings.entrySet();

        // Obtain an Iterator for the entries Set
        Iterator it = entrySet.iterator();

        // Iterate through Hashtable entries
        while (it.hasNext()) {

            JSONObject jsonAssign = new JSONObject();

            // ***** Build the assignment object
            String htEntry = it.next().toString();
            String[] split = htEntry.split("=");

            jsonAssign.put(split[0], split[1]);

            // ***** Add the Object to the Array
            settingsArray.add(jsonAssign);
        }

        objAssign.put("Settings", settingsArray);

        // ***** Write the JSONArray to file
        try {            
            FileWriter file = new FileWriter("data/settings.json");
            file.write(objAssign.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;

    }

    public static String RetrieveSettingValueByKey(String Key) {

        return settings.get(Key).toString();
    }
}