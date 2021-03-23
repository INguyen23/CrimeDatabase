package CrimeDatabase;

public abstract  class DataConstants {
    protected static final String OFFICER_FILE_NAME = "CrimeDatabase/user.json";
    protected static final String OFFICER_ID = "id";
    protected static final String OFFICER_USERNAME = "username";
    protected static final String OFFICER_PASSWORD = "password";
    protected static final String OFFICER_NAME = "name";
    protected static final String OFFICER_AGE = "age";
    protected static final String OFFICER_BADGE_ID = "badgeID";

    protected static final String SUSPECT_FILE_NAME = "CrimeDatabase/subject.json";
    protected static final String SUSPECT_ID = "id";
    protected static final String SUSPECT_NAME = "name";
    protected static final String SUSPECT_AGE = "age";
    protected static final String SUSPECT_SEX = "sex";
    protected static final String SUSPECT_WEIGHT = "weight";
    protected static final String SUSPECT_HEIGHT = "height";
    protected static final String SUSPECT_EYECOLOR = "eyecolor";
    protected static final String SUSPECT_HAIRCOLOR = "haircolor";
    protected static final String SUSPECT_DESCRIPTION = "description";

    protected static final String CASE_FILE_NAME = "CrimeDatabase/case.json";
    protected static final String CASE_SUBJECT_ID = "subjectID";
    protected static final String CASE_USER_ID = "userID";
    protected static final String CASE_LEVEL = "level";
    protected static final String CASE_DATE = "date";
    protected static final String CASE_EVIDENCE = "evidence";
    protected static final String CASE_WITNESSES = "witnesses";
    protected static final String CASE_VICTIM_INFO = "victimInfo";
    protected static final String CASE_DESCRIPTION = "description";
}
