package CrimeDatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() { 
        Users users = Users.getInstance();
        ArrayList<User> u = users.getUsers();
        JSONArray jsonU = new JSONArray();

        for(int i = 0; i < u.size(); i++) {
            jsonU.add(getUserJSON(u.get(i)));
        }

        try(FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonU.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) { 
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID());
        userDetails.put(USER_USERNAME, user.getUser());
        userDetails.put(USER_PASSWORD, user.getPass());
        userDetails.put(USER_NAME, user.getName());
        userDetails.put(USER_AGE, user.getAge());
        userDetails.put(USER_BADGE_ID, user.getBadgeID());

        return userDetails;
    }



    public static void saveSubjects() { 
        Subjects subjects = Subjects.getInstance();
        ArrayList<Subject> s = subjects.getSubjects();
        JSONArray jsonS = new JSONArray();

        for(int i = 0; i < s.size(); i++) {
            jsonS.add(getSubjectJSON(s.get(i)));
        }

        try(FileWriter file = new FileWriter(SUBJECT_FILE_NAME)) {
            file.write(jsonS.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getSubjectJSON(Subject subject) { 
        JSONObject subjectDetails = new JSONObject();
        subjectDetails.put(SUBJECT_ID, subject.getID());
        subjectDetails.put(SUBJECT_NAME, subject.getName());
        subjectDetails.put(SUBJECT_AGE, subject.getAge());
        subjectDetails.put(SUBJECT_SEX, subject.getSex());
        subjectDetails.put(SUBJECT_WEIGHT, subject.getWeight());
        subjectDetails.put(SUBJECT_HEIGHT, subject.getHeight());
        subjectDetails.put(SUBJECT_EYECOLOR, subject.getEyeColor());
        subjectDetails.put(SUBJECT_HAIRCOLOR, subject.getHairColor());
        subjectDetails.put(SUBJECT_DESCRIPTION, subject.getDescription());

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
        caseDetails.put(CASE_NUMBER, case1.getCaseNum());
        caseDetails.put(CASE_LEVEL, case1.getLevel());
        caseDetails.put(CASE_DATE, case1.getDate());
        caseDetails.put(CASE_EVIDENCE, case1.getEvidence());
        caseDetails.put(CASE_WITNESSES, case1.getWitnesses());
        caseDetails.put(CASE_VICTIM_INFO, case1.getVictimInfo());
        caseDetails.put(CASE_DATE, case1.getDescription());

        return caseDetails;
    }
}
