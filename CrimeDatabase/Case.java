package CrimeDatabase;

public class Case {
    private int id;
    private String level;
    private String date;
    private String[] evidence;
    private String[] witnesses;
    private String[] victimInfo;
    private String description;

    public Case(int id, String level, String date, String[] evidence, String[] witnesses, String[] victimInfo, String description) {
    	this.id = id;
        this.level = level;
        this.date = date;
        this.evidence = evidence;
        this.witnesses = witnesses;
        this.victimInfo = victimInfo;
        this.description = description;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setLevel(String level) {
    	this.level = level; 
    }

    public void setWitnesses(String[] witnesses) {
        this.witnesses = witnesses;
    }

    public void setDate(String date) {
    	this.date = date; 

    }

    public void setDescription(String description) {
    	this.description = description; 

    }

    public void setEvidence(String[] evidence) {
    	this.evidence = evidence;

    }
    
	public void setVictimInfo(String[] victimInfo) {
		this.victimInfo = victimInfo;
	}

    public int getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public String[] getWitnesses() {
        return witnesses;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String[] getEvidence() {
        return evidence;
    }

	public String[] getVictimInfo() {
		return victimInfo;
	}
}