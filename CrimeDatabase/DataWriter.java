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
        officerDetails.put(OFFICER_ID, officer.getID());
        officerDetails.put(OFFICER_USERNAME, officer.getUser());
        officerDetails.put(OFFICER_PASSWORD, officer.getPass());
        officerDetails.put(OFFICER_NAME, officer.getName());
        officerDetails.put(OFFICER_AGE, officer.getAge());
        officerDetails.put(OFFICER_BADGE_ID, officer.getBadgeID());

        return officerDetails;
    }


    public static void saveSuspects() { 
        Suspects suspects = Suspects.getInstance();
        ArrayList<Suspect> s = suspects.getSuspects();
        JSONArray jsonS = new JSONArray();

        for(int i = 0; i < s.size(); i++) {
            jsonS.add(getSuspectJSON(s.get(i)));
        }

        try(FileWriter file = new FileWriter(SUS_FILE_NAME)) {
            file.write(jsonS.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getSuspectJSON(Suspect suspect) { 
        JSONObject subjectDetails = new JSONObject();
        subjectDetails.put(SUS_ID, suspect.getID());
        subjectDetails.put(SUS_NAME, suspect.getName());
        subjectDetails.put(SUS_AGE, suspect.getAge());
        subjectDetails.put(SUS_SEX, suspect.getSex());
        subjectDetails.put(SUS_WEIGHT, suspect.getWeight());
        subjectDetails.put(SUS_DESCRIPTION, suspect.getDescription());

        return subjectDetails;
    }



    public static void saveCases(){
        Cases cases = Cases.getInstance();
        ArrayList<Case> c = cases.getCases();
        JSONArray jsonC = new JSONArray();

        for(int i = 0; i < c.size(); i++) {
            jsonC.add(getCaseJSON(c.get(i)));
        }

        try(FileWriter file = new FileWriter(CASE_FILE_NAME)) {
            file.write(jsonC.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCaseJSON(Case case1) { 
        JSONObject caseDetails = new JSONObject();
        caseDetails.put(CASE_ID, case1.getId());
        caseDetails.put(CASE_LEVEL, case1.getLevel());
        caseDetails.put(CASE_DATE, case1.getDate());
        caseDetails.put(CASE_EVIDENCE, case1.getEvidence());
        caseDetails.put(CASE_WITNESSES, case1.getWitnesses());
        caseDetails.put(CASE_VICTIM_INFO, case1.getVictimInfo());
        caseDetails.put(CASE_DATE, case1.getDescription());

        return caseDetails;
    }
}
