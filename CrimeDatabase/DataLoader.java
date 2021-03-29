package CrimeDatabase;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                int ID = ((Long)userJSON.get(USER_ID)).intValue();
                String userName = (String)userJSON.get(USER_USERNAME);
                String pass = (String)userJSON.get(USER_PASSWORD);
                String name = (String)userJSON.get(USER_NAME);
                int age = ((Long)userJSON.get(USER_AGE)).intValue();
                String badgeID = (String)userJSON.get(USER_BADGE_ID);

                users.add(new User(ID, userName, pass, name, age, badgeID));
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Case> loadCases() {
        ArrayList<Case> cases = new ArrayList<Case>();

        try {
            FileReader reader = new FileReader(CASE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray casesJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < casesJSON.size(); i++) {
                JSONObject caseJSON = (JSONObject)casesJSON.get(i);
                int caseNum = ((Long)caseJSON.get(CASE_NUMBER)).intValue();
                String level = (String)caseJSON.get(CASE_LEVEL);
                String date = (String)caseJSON.get(CASE_DATE);
                String evidence = (String)caseJSON.get(CASE_EVIDENCE);
                String witnesses = (String)caseJSON.get(CASE_WITNESSES);
                String victimInfo = (String)caseJSON.get(CASE_VICTIM_INFO);
                String description = (String)caseJSON.get(CASE_DESCRIPTION);
                String suspect = (String)caseJSON.get(CASE_SUSPECT);

                cases.add(new Case(caseNum, level, date, evidence, witnesses, victimInfo, description, suspect));
            }

            return cases;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Subject> loadSubjects() {
        ArrayList<Subject> subjects = new ArrayList<Subject>();

        try {
            FileReader reader = new FileReader(SUBJECT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray subjectsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < subjectsJSON.size(); i++) {
                JSONObject subjectJSON = (JSONObject)subjectsJSON.get(i);
                int ID = ((Long)subjectJSON.get(SUBJECT_ID)).intValue();
                String name = (String)subjectJSON.get(SUBJECT_NAME);
                int age = ((Long)subjectJSON.get(SUBJECT_AGE)).intValue();
                String sex = (String)subjectJSON.get(SUBJECT_SEX);
                int weight = ((Long)subjectJSON.get(SUBJECT_WEIGHT)).intValue();
                String height = (String)subjectJSON.get(SUBJECT_HEIGHT);
                String eyeColor = (String)subjectJSON.get(SUBJECT_EYECOLOR);
                String hairColor = (String)subjectJSON.get(SUBJECT_HAIRCOLOR);
                String description = (String)subjectJSON.get(SUBJECT_DESCRIPTION);
                String crime = (String)subjectJSON.get(SUBJECT_CRIME);

                subjects.add(new Subject(ID, name, age, sex, weight, height, eyeColor, hairColor, description, crime));
            }

            return subjects;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}