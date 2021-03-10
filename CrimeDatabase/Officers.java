package CrimeDatabase;

import java.util.ArrayList;

public class Officers {
    private static Officers officers;
    private ArrayList<Officer> officerList;

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

    public void addOfficer(String name, int age, int arrest) { 
        officerList.add(new Officer(name,age,arrest));
        DataWriter.saveOfficers();
    }
}
