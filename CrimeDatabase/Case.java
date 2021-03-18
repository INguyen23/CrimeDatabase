package CrimeDatabase;

public class Case {
    private int id;
    private Crime level;
    private Person subject;
    private Person arrestingOfficer;
    private String date;
    private Evidence [] evidence;
    private String description;

    public void setId() {

    }
    
    public void setLevel() {

    }

    public void setSubject() {

    }

    public void setDate() {

    }

    public void setDescription() {

    }

    public void setEvidence() {

    }

    public int getId() {
        return id;
    }

    public Crime getLevel() {
        return level;
    }

    public Person getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Evidence [] getEvidence() {
        return evidence;
    }
}
