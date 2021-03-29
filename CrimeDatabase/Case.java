package CrimeDatabase;

public class Case {
    private int caseNum;
    private String level;
    private String date;
    private String evidence;
    private String witnesses;
    private String victimInfo;
    private String description;

    public Case(int caseNum, String level, String date, String evidence, String witnesses, String victimInfo, String description) { 
        this.caseNum = caseNum;
        this.level = level;
        this.date = date;
        this.evidence = evidence;
        this.witnesses = witnesses;
        this.victimInfo = victimInfo;
        this.description = description;
    }

    public int getCaseNum() { 
        return caseNum;
    }

    public void setCaseNum(int caseNum) { 
        this.caseNum = caseNum;
    }

    public String getLevel()  {
        return level;
    }

    public void setLevel(String level) { 
        this.level = level;
    }

    public String getDate() { 
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) { 
        this.evidence = evidence;
    }

    public String getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(String witnesses) { 
        this.witnesses = witnesses;
    }

    public String getVictimInfo() { 
        return victimInfo;
    }

    public void setVictimInfo(String victimInfo) { 
        this.victimInfo = victimInfo;
    }

    public String getDescription() { 
        return description;
    }

    public void setDescription(String description) { 
        this.description = description;
    }
}