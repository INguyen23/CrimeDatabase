package CrimeDatabase;

public class Officer extends Person{
    private String name;
    private int age;
    private int arrests;

    public Officer(String name, int age, int arrests) {
        this.name = name;
        this.age = age;
        this.arrests =arrests;
    }

    public String getName() { 
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getArrests() {
        return arrests;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setArrests(int arrests){
        this.arrests=arrests;
    }
}
