package CrimeDatabase;

import java.util.ArrayList;
import java.util.Iterator;

public class Officers {
    private static Officers officers = null;
    private ArrayList<Officer> officerList = new ArrayList<Officer>();

    private Officers() { 
        officerList = DataLoader.loadOfficers();
    }

    public static Officers getInstance() {
        if(officers == null) {
            officers = new Officers();
        }
        return officers;
    }

    public ArrayList<Officer> getOfficers() { 
        return officerList;
    }

    public void addOfficer(int id, String userName, String pass, String name, int age, String badgeID) { 
        officerList.add(new Officer( id,  userName,  pass,  name,  age,  badgeID));
        DataWriter.saveOfficers();
    }

    public Iterator<Officer> createIterator() {
        return officerList.iterator();
    }
}
