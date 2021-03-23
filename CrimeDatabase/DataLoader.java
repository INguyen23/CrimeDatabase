package CrimeDatabase;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    
    //load data for officer
    public static ArrayList<Officer> loadOfficers() {
        ArrayList<Officer> officers = new ArrayList<Officer>();
        
        try { 
        FileReader reader = new FileReader(OFFICER_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray officersJSON = (JSONArray)new JSONParser().parse(reader);

        for (int i = 0 ; i < officersJSON.size(); i++) {
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

    //load data for case
    public static ArrayList<Case> loadCases() {
        ArrayList<Case> cases = new ArrayList<Case>();

        try {
            FileReader reader = new FileReader(CASE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray casesJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < casesJSON.size(); i++) {
                JSONObject caseJSON = (JSONObject)casesJSON.get(i);
                int subjectID = (int)caseJSON.get(CASE_SUBJECT_ID);
                int userID = (int) caseJSON.get(CASE_USER_ID);
                String level = (String)caseJSON.get(CASE_LEVEL);
                String date = (String)caseJSON.get(CASE_DATE);
                String evidence = (String)caseJSON.get(CASE_EVIDENCE);
                String witnesses = (String)caseJSON.get(CASE_WITNESSES);
                String victimInfo = (String)caseJSON.get(CASE_VICTIM_INFO);
                String description = (String)caseJSON.get(CASE_DESCRIPTION);

                cases.add(new Case(subjectID, userID, level, date, evidence, witnesses, victimInfo, description));
            }

            return cases;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //load data for suspect
    public static ArrayList<Suspect> loadSuspects() {
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();

        try {
            FileReader reader = new FileReader(SUSPECT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray suspectsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < suspectsJSON.size(); i++) {
                JSONObject suspectJSON = (JSONObject)suspectsJSON.get(i);
                int ID = (int)suspectJSON.get(SUSPECT_ID);
                String name = (String)suspectJSON.get(SUSPECT_NAME);
                int age = (int)suspectJSON.get(SUSPECT_AGE);
                String sex = (String)suspectJSON.get(SUSPECT_SEX);
                int weight = (int)suspectJSON.get(SUSPECT_WEIGHT);
                String height = (String)suspectJSON.get(SUSPECT_HEIGHT);
                String eyeColor = (String)suspectJSON.get(SUSPECT_EYECOLOR);
                String hairColor = (String)suspectJSON.get(SUSPECT_HAIRCOLOR);
                String description = (String)suspectJSON.get(SUSPECT_DESCRIPTION);

                suspects.add(new Suspect(ID, name, age, sex, weight, height, eyeColor, hairColor, description));
            }

            return suspects;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}