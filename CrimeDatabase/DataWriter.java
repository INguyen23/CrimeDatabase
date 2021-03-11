package CrimeDatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveOfficers() {
        Officers officers = Officers.getInstance();
        ArrayList<Officer> o = officers.getOfficers();
        JSONArray jsonO = new JSONArray();

        for(int i=0;i<o.size();i++) {
            jsonO.add(getOfficerJSON(o.get(i)));
        }

        try (FileWriter file = new FileWriter(OFFICER_FILE_NAME)) {

            file.write(jsonO.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getOfficerJSON(Officer officer) {
        JSONObject officerDetails = new JSONObject();
        officerDetails.put(OFFICER_NAME, officer.getName());
        officerDetails.put(OFFICER_AGE, officer.getAge());

        return officerDetails;
    }
}
