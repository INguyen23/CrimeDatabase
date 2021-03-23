package CrimeDatabase;

public class Officer {
    private int ID;
    private String userName;
    private String pass;
    private String name;
    private int age;
    private String badgeID;

    public Officer(int ID, String userName, String pass, String name, int age, String badgeID) { 
        this.ID = ID;
        this.userName = userName;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.badgeID = badgeID;
    }

    public int getID() { 
        return ID;
    }

    public void setId(int ID) { 
        this.ID = ID;
    }

    public String getUser() { 
        return userName;
    }

    public void setUser(String userName) { 
        this.userName = userName;
    }

    public String getPass() { 
        return pass;
    }

    public void setPass(String pass) { 
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { 
        this.age = age;
    }

    public String getBadgeID() { 
        return badgeID;
    }

    public void setBadgeID(String badgeID) { 
        this.badgeID = badgeID;
    }
}