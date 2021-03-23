package CrimeDatabase;

import java.util.ArrayList;

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

    public void addOfficer(int ID, String userName, String pass, String name, int age, String badgeID) { 
        officerList.add(new Officer( ID,  userName,  pass,  name,  age,  badgeID));
        DataWriter.saveOfficers();
    }
}
