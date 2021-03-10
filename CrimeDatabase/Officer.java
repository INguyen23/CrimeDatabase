package CrimeDatabase;

public class Officer {
    private String name;
    private int age;
    private int arrest;

    public Officer(String name, int age, int arrest) {
        this.name = name;
        this.age = age;
        this.arrest = arrest;
    }

    public String getName() { 
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getArrest() {
        return arrest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setArrest(int arrest) { 
        this.arrest = arrest;
    }
}
