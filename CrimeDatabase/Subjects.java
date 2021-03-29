package CrimeDatabase;

import java.util.ArrayList;
import java.util.Iterator;

public class Subjects {
    private static Subjects subjects = null;
    private ArrayList<Subject> subjectList = new ArrayList<Subject>();

    private Subjects() { 
        subjectList = DataLoader.loadSubjects();
    }

    public static Subjects getInstance() {
        if(subjects == null) {
            subjects = new Subjects();
        }
        return subjects;
    }

    public ArrayList<Subject> getSubjects() { 
        return subjectList;
    }

    public void addSubject(int ID, String name, int age, String sex, int weight, String height, String eyeColor, String hairColor, String description) { 
        subjectList.add(new Subject( ID,  name,  age,  sex,  weight,  height,  eyeColor,  hairColor,  description));
        DataWriter.saveSubjects();
    }
}
