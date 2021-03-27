package CrimeDatabase;

import java.util.ArrayList;
import java.util.Iterator;

public class Suspects {
    private static Suspects suspects = null;
    private ArrayList<Suspect> susList = new ArrayList<Suspect>();

    private Suspects() { 
        susList = DataLoader.loadSuspects();
    }

    public static Suspects getInstance() { 
        if (suspects == null) {
            suspects = new Suspects();
        }
        return suspects;
    }

    public ArrayList<Suspect> getSuspects() { 
        return susList;
    }

    public void addSus(int ID, String name, int age, String sex, int weight, String[] description) { 
        susList.add(new Suspect(ID, name, age, sex, weight, description));
        DataWriter.saveCases();
    }

    public Iterator<Suspect> createIterator() { 
        return susList.iterator();
    }
}
