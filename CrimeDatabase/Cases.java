package CrimeDatabase;

import java.util.ArrayList;
import java.util.Iterator;

public class Cases {
    private static Cases cases = null;
    private ArrayList<Case> caseList = new ArrayList<Case>();

    private Cases() { 
        caseList = DataLoader.loadCases();
    }

    public static Cases getInstance() {
        if(cases == null) {
            cases = new Cases();
        }
        return cases;
    }

    public ArrayList<Case> getCases() { 
        return caseList;
    }

    public void addCase(int caseNum, String level, String date, String evidence, String witnesses, String victimInfo, String description) { 
        caseList.add(new Case(caseNum, level, date, evidence, witnesses, victimInfo, description));
        DataWriter.saveCases();
    }

    public Iterator<Case> createIterator() {
        return caseList.iterator();
    }
}