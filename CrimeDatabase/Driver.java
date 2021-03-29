package CrimeDatabase;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;


public class Driver {
    private Scanner in;

    public Driver() { 
        in = new Scanner(System.in);
    }

    private String getField(String prompt) { 
        System.out.println(prompt  + ": ");
        return in.nextLine();
        
    }

    private int getNumField(String word) { 
        System.out.println(word +": ");
        int ret = in.nextInt();
        in.nextLine();
        return ret;
    }

    public boolean checkAddAcc() { 
        System.out.println("Would you like to Create an Account? (y/n)");
        String input = in.nextLine();

        if (input.toLowerCase().trim().equals("y")) { 
            return true;
        } else { 
            return false;
        }
    }

    public void displayUsers() {
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getUsers();

        for (User user : userList) {
            System.out.println(user.getID()+user.getUser()+user.getPass()+user.getName()+user.getAge()+user.getBadgeID());
        }
    }

    public void displayCases() { 
        Cases cases = Cases.getInstance();
        ArrayList<Case> caseList = cases.getCases();

        for(Case case1 : caseList) { 
            System.out.println(case1.getCaseNum()+case1.getLevel());
        }
    }

    public void addAccount() { 
        Users users = Users.getInstance();

        if(checkAddAcc()) { 
            int ID = getNumField("Enter ID");
            String userName = getField("Enter username");
            String pass = getField("Enter password");
            String name = getField("Enter name");
            int age = getNumField("Enter age");
            String badgeID = getField("Enter Badge ID");

            users.addUser(ID, userName, pass, name, age, badgeID);
            System.out.println("Account Created!");
            play();
        }
        else {
            play();
        }   
    }

    private void checkLogin() throws IOException  {
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getUsers();

        System.out.println("Enter Username: ");
        String userinput = in.next();
        System.out.println("Enter Password: ");
        String passInput = in.next();
        in.nextLine();

        int size = userList.size();
        boolean check = false;
        for (User user : userList) {
            if(user.getUser().equals(userinput) && user.getPass().equals(passInput)) {
                System.out.println("Successfully Logged in!");
                check = true;
            }
        }
        if(check) {
            chooseFromMenu();
        }
        else {
            System.out.println("Incorrect Log in");
            play();
        }
    }

    public boolean checkAddCase() { 
        System.out.println("Would you like to add a case? (y/n)");
        String input = in.next();

        if (input.toLowerCase().trim().equals("y")) { 
            return true;
        } else {
            return false;
        }
    }

    public void addCase() { 
        Cases cases = Cases.getInstance();

        if(checkAddCase()) { 
            int caseNum = getNumField("Enter case number");
            String level = getField("Enter case level");
            String date = getField("Enter case date");
            String evidence = getField("Enter case evidence");
            String witnesses = getField("Enter witnesses");
            String victimInfo = getField("Enter victim Information");
            String description = getField("Enter case description");
            String suspect = getField("Enter case suspect");

            cases.addCase(caseNum, level, date, evidence, witnesses, victimInfo, description, suspect);
            System.out.println("Added new case!");
        }
    }

    public boolean checkAddSubject() { 
        System.out.println("Would you like to add a suspect?");
        String input = in.next();

        if (input.toLowerCase().trim().equals("y")) { 
            return true;
        } else { 
            return false;
        }
    }

    public void searchCase() throws IOException { 
        Cases cases = Cases.getInstance();
        ArrayList<Case> caseList = cases.getCases();

        System.out.println("Search for Case(Enter 0 for unknown fields)");
        int id = getNumField("Enter case number");
        String level = getField("Enter case level");
        String date = getField("Enter case date");
        String evidence = getField("Enter case evidence");
        String witnesses = getField("Enter witnesses");
        String victimInfo = getField("Enter victim Information");
        String description = getField("Enter case description");
        String suspect = getField("Enter case suspect");

        File caseDisplay = new File("CaseDisplay.txt");
        boolean bool = caseDisplay.delete();
        bool = caseDisplay.createNewFile();
        FileWriter writer = new FileWriter(caseDisplay);
        BufferedWriter out = new BufferedWriter(writer);
        Desktop desk = Desktop.getDesktop();

        for (Case case1 : caseList) { 
            if(id == case1.getCaseNum() || case1.getLevel().equalsIgnoreCase(level) || case1.getDate().equalsIgnoreCase(date) || case1.getEvidence().equalsIgnoreCase(evidence) || case1.getWitnesses().equalsIgnoreCase(witnesses) || case1.getVictimInfo().equalsIgnoreCase(victimInfo) || case1.getDescription().equalsIgnoreCase(description)) { 
                System.out.println("Case #: " +  case1.getCaseNum() + "\nLevel: " + case1.getLevel() + "\nDate:" + case1.getDate() + "\nEvidence: " + case1.getEvidence() + "\nWitnesses: " + case1.getWitnesses()
                + "\nVictim Info: " + case1.getVictimInfo() + "\nDescription: " + case1.getDescription() + "\nSuspect: " + case1.getSuspect());
                System.out.println();

                out.write("Case #: " +  case1.getCaseNum() + "\nLevel: " + case1.getLevel() + "\nDate:" + case1.getDate() + "\nEvidence: " + case1.getEvidence() + "\nWitnesses: " + case1.getWitnesses()
                + "\nVictim Info: " + case1.getVictimInfo() + "\nDescription: " + case1.getDescription() + "\nSuspect: " + case1.getSuspect()+"\n\n\n");
            }
        }
        out.close();
        desk.open(caseDisplay);
    }

    public void addSubject() { 
        Subjects subjects = Subjects.getInstance();

        while(checkAddSubject()) { 
            int ID = getNumField("Enter ID");
            String name = getField("Enter suspect name");
            int age = getNumField("Enter suspect age");
            String sex = getField("Enter suspect sex");
            int weight = getNumField("Enter suspect weight");
            String height = getField("Enter suspect height");
            String eyeColor = getField("Enter suspect eye color");
            String hairColor = getField("Enter suspect hair color");
            String description = getField("Enter description of suspect");
            String crime = getField("Enter crimes of suspect and contact info");

            subjects.addSubject(ID, name, age, sex, weight, height, eyeColor, hairColor, description, crime);
            System.out.println("Added new suspect!");
        }
    }

    public void searchSubject() throws IOException {
        Subjects subjects = Subjects.getInstance();
        ArrayList<Subject> subList = subjects.getSubjects();

        System.out.println("Search for Suspects(Enter 0 for unknown fields)");
        int ID = getNumField("Enter ID");
        String name = getField("Enter suspect name");
        int age = getNumField("Enter suspect age");
        String sex = getField("Enter suspect sex");
        int weight = getNumField("Enter suspect weight");
        String height = getField("Enter suspect height");
        String eyeColor = getField("Enter suspect eye color");
        String hairColor = getField("Enter suspect hair color");
        String description = getField("Enter description of suspect");

        File subjectDisplay = new File("SubjectDisplay.txt");
        boolean bool = subjectDisplay.delete();
        bool = subjectDisplay.createNewFile();
        FileWriter writer = new FileWriter(subjectDisplay);
        BufferedWriter out = new BufferedWriter(writer);
        Desktop desk = Desktop.getDesktop();

        for (Subject subject : subList) { 
            if(ID == subject.getID() || subject.getName().equalsIgnoreCase(name) || age == subject.getAge() || subject.getSex().equalsIgnoreCase(sex) || weight == subject.getWeight() || subject.getHeight().equalsIgnoreCase(height) || subject.getEyeColor().equalsIgnoreCase(eyeColor) || subject.getHairColor().equalsIgnoreCase(hairColor) || subject.getDescription().equalsIgnoreCase(description)) { 
                System.out.println("ID: " + subject.getID() + "\nName: " + subject.getName() + "\nAge: " + subject.getAge() + "\nSex: " + subject.getSex() + "\nWeight: " + subject.getWeight() 
                + "\nHeight: " + subject.getHeight() + "\nEye Color: " + subject.getEyeColor() + "\nHair Color: " + subject.getHairColor() 
                + "\nDescription: " + subject.getDescription());
                System.out.println();
                out.append("ID: " + subject.getID() + "\nName: " + subject.getName() + "\nAge: " + subject.getAge() + "\nSex: " + subject.getSex() + "\nWeight: " + subject.getWeight() 
                + "\nHeight: " + subject.getHeight() + "\nEye Color: " + subject.getEyeColor() + "\nHair Color: " + subject.getHairColor() 
                + "\nDescription: " + subject.getDescription()+"\nCrime and Contact info: "+subject.getCrime()+"\n\n\n");
            } 
        }
        out.close();
        desk.open(subjectDisplay);
    }

    public void chooseFromMenu() throws IOException { 
        System.out.println("What would you like to do:\n1.) Add Case\n2.) Search Case\n3.) Add Suspect\n4.) Search Suspect");
        int input = in.nextInt();

        if (input == 1) { 
            addCase();
        } else if (input == 2) {
            searchCase();
        } else if (input == 3) { 
            addSubject();
        } else if (input == 4) { 
            searchSubject();
        } else {
            System.out.println("Option not found");
        }
        chooseFromMenu();
    }

    public void play() {
        System.out.println("Welcome to Our Crime Database!\nChoose an option: \n1.) Create Account\n2.) Login");
        int ans = in.nextInt();
        in.nextLine();
        if (ans == 1) { 
            addAccount();
        } else if (ans == 2) { 
            try {
                checkLogin();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else { 
            System.out.println("Option not found");
        }
    }

    public static void main(String [] args) {
        Driver d = new Driver();
        d.play();
    }
}

