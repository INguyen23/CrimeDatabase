package CrimeDatabase;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    
    public static ArrayList<Officer> loadOfficers() {
        ArrayList<Officer> officers = new ArrayList<Officer>();
        
        try { 
        FileReader reader = new FileReader(OFFICER_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray officersJSON = (JSONArray)new JSONParser().parse(reader);

        for(int i=0;i<officersJSON.size();i++) {
            JSONObject officerJSON = (JSONObject)officersJSON.get(i);
            String name = (String)officerJSON.get(OFFICER_NAME);
            int age = (int)officerJSON.get(OFFICER_AGE);

            officers.add(new Officer(name, age));
        }

        return officers;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
    }
}