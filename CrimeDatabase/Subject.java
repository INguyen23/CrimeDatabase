package CrimeDatabase;

public class Subject {
    private int ID;
    private String name;
    private int age;
    private String sex;
    private int weight;
    private String height;
    private String eyeColor;
    private String hairColor;
    private String description;

    public Subject(int ID, String name, int age, String sex, int weight, String height2, String eyeColor, String hairColor, String description) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height2;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
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

    public String getHeight() { 
        return height;
    }

    public void setHeight(String height) { 
        this.height = height;
    }

    public String getEyeColor() { 
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) { 
        this.eyeColor = eyeColor;
    }

    public String getHairColor() { 
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { 
        this.description = description;
    }
}
