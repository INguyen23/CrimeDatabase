package CrimeDatabase;

public class Suspect {
    private int ID;
    private String name;
    private int age;
    private String sex;
    private int weight;
    private String[] description;

    public Suspect(int ID, String name, int age, String sex, int weight, String[] description) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.description = description;
    }

    public int getID() { 
        return ID;
    }

    public void setID(int ID) { 
        this.ID = ID;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getWeight() { 
        return weight;
    }

    public void setWeight(int weight) { 
        this.weight = weight;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) { 
        this.description = description;
    }
}
