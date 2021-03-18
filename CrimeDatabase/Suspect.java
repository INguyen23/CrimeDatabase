package CrimeDatabase;

public class Suspect extends Person{
    private String name;
    private int age;

    public void Suspect(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() { 
        return name;
    }

    public int getAge() { 
        return age;
    }
}
