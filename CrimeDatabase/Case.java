package CrimeDatabase;

public class Case {
    private int id;
    private Crime level;
    private Person subject;
    private Person arrestingOfficer;
    private String date;
    private Evidence [] evidence;
    private String description;

    public Case(int id, Crime level, Person subject, Person arrestingOfficer, String date, Evidence evidence, String description) {
    	this.id = id;
        this.level = level;
        this.subject = subject;
        this.arrestingOfficer = arrestingOfficer;
        this.date = date;
        this.evidence = evidence;
        this.description = description;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setLevel(Crime level) {
    	this.level = level; 
    }

    public void setSubject(Person subject) {
    	this.subject = subject; 
    }

    public void setDate(String Date) {
    	this.date = Date; 

    }

    public void setDescription(String description) {
    	this.description = description; 

    }

    public void setEvidence(Evidence[] evidence) {
    	this.evidence = evidence;

    }
    
	public void setArrestingOfficer(Person arrestingOfficer) {
		this.arrestingOfficer = arrestingOfficer;
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

	public Person getArrestingOfficer() {
		return arrestingOfficer;
	}
}