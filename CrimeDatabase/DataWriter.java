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
        officerDetails.put(OFFICER_ARRESTS, officer.getArrests());

        return officerDetails;
    }


    public static void saveSuspects() { 
        Suspects suspects = Suspects.getInstance();
        ArrayList<Suspect> s = suspects.getSuspects();
        JSONArray jsonS = new JSONArray();

        for(int i = 0; i < s.size(); i++) {
            jsonS.add(getSuspectJSON(s.get(i)));
        }

        try(FileWriter file = new FileWriter(SUSPECT_FILE_NAME)) {
            file.write(jsonS.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getSuspectJSON(Suspect suspect) { 
        JSONObject suspectDetails = new JSONObject();
        subjectDetails.put(SUSPECT_ID, suspect.getID());
        subjectDetails.put(SUSPECT_NAME, suspect.getName());
        subjectDetails.put(SUSPECT_AGE, suspect.getAge());
        subjectDetails.put(SUSPECT_SEX, suspect.getSex());
        subjectDetails.put(SUSPECT_WEIGHT, suspect.getWeight());
        subjectDetails.put(SUSPECT_HEIGHT, suspect.getHeight());
        subjectDetails.put(SUSPECT_EYECOLOR, suspect.getEyeColor());
        subjectDetails.put(SUSPECT_HAIRCOLOR, suspect.getHairColor());
        subjectDetails.put(SUSPECT_DESCRIPTION, suspect.getDescription());

        return suspectDetails;
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
        caseDetails.put(CASE_SUBJECT_ID, case1.getSubjectID());
        caseDetails.put(CASE_USER_ID, case1.getUserID());
        caseDetails.put(CASE_LEVEL, case1.getLevel());
        caseDetails.put(CASE_DATE, case1.getDate());
        caseDetails.put(CASE_EVIDENCE, case1.getEvidence());
        caseDetails.put(CASE_WITNESSES, case1.getWitnesses());
        caseDetails.put(CASE_VICTIM_INFO, case1.getVictimInfo());
        caseDetails.put(CASE_DATE, case1.getDescription());

        return caseDetails;
    }
}
