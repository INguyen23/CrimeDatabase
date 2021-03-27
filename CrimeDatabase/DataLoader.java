package CrimeDatabase;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

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
            int id = ((Long)officerJSON.get(OFFICER_ID)).intValue();
            String userName = (String)officerJSON.get(OFFICER_USERNAME);
            String password = (String)officerJSON.get(OFFICER_PASSWORD);
            String name = (String)officerJSON.get(OFFICER_NAME);
            int age = ((Long)officerJSON.get(OFFICER_AGE)).intValue();
            String badgeID = (String)officerJSON.get(OFFICER_BADGE_ID);

            officers.add(new Officer(id, userName, password, name, age, badgeID));
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
                int id = ((Long)caseJSON.get(CASE_ID)).intValue();
                String level = (String)caseJSON.get(CASE_LEVEL);
                String date = (String)caseJSON.get(CASE_DATE);
                String[] evidence = (String[])caseJSON.get(CASE_EVIDENCE);
                String[] witnesses = (String[])caseJSON.get(CASE_WITNESSES);
                String[] victimInfo = (String[])caseJSON.get(CASE_VICTIM_INFO);
                String description = (String)caseJSON.get(CASE_DESCRIPTION);

                cases.add(new Case(id, level, date, evidence, witnesses, victimInfo, description));
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
                int ID = ((Long)suspectJSON.get(SUS_ID)).intValue();
                String name = (String)suspectJSON.get(SUS_NAME);
                int age = ((Long)suspectJSON.get(SUS_AGE)).intValue();
                String sex = (String)suspectJSON.get(SUS_SEX);
                int weight = ((Long)suspectJSON.get(SUS_WEIGHT)).intValue();
                String[] description = (String[])suspectJSON.get(SUS_DESCRIPTION);

                suspects.add(new Suspect(ID, name, age, sex, weight, description));
            }

            return suspects;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}