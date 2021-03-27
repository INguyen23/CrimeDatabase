package CrimeDatabase;

public abstract class Person {
    String name;
    int age;

    public void setName(){
        this.name = name;
    }
    public void setAge(){
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
