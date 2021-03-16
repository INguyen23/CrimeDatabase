package CrimeDatabase;

public class Infraction extends Crime {
    private int jailTime;
    private String crimeType;

    public Infraction() {
        this.getJailTime();
        this.getcrimeType();
    }
}
