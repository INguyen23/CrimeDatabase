package CrimeDatabase;

public class Criminal {
    private String name;
    private int age;
    private int convictions;

    public Criminal (String name, int age, int convictions) {
        this.name = name;
        this.age = age;
        this.convictions = convictions;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public void setAge(int age) { 
        this.age = age;
    }

    public void setConvictions(int convictions) { 
        this.convictions = convictions;
    }

    public String getName() { 
        return name;
    }

    public int getAge() { 
        return age;
    }

    public int getConvictions() { 
        return convictions;
    }
}
