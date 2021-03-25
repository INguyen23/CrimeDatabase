package CrimeDatabase;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Driver extends JFrame {
    private Scanner scanner;
    private static String accessLevel;
    private static ArrayList<Case> cases;
    private static ArrayList<String> users;
    private static ArrayList<String> pass;
    private static ArrayList<String> accessLevels;
    private static Login loginFrame;
    private static Main mainFrame;

    public Driver() {
        scanner = new Scanner(System.in);
    }

    protected void editInfo() {

    }

    protected Case searchCases(String input) {
        System.out.println("Search through cases: ");
        //String input = scanner.next();
        
        for(Case case1 : cases) {
            boolean containsEvidence = false;
            for(Evidence evidence1 : case1.getEvidence()) {
                if(evidence1.getDescription().equalsIgnoreCase(input)){
                    containsEvidence = true;
                }
            }
            if ((""+case1.getId()).equalsIgnoreCase(input) || (case1.getLevel().getcrimeType()).equalsIgnoreCase(input) || (case1.getSubject().getName()).equalsIgnoreCase(input) 
            || case1.getDate().equalsIgnoreCase(input) || containsEvidence || case1.getDescription().equalsIgnoreCase(input)) { 
                return case1;
            }
        }
        return null;   
    }

    protected boolean addCase() {
        System.out.println("Would you like to add a new case (Y/N)?");
        String input = scanner.next();
        
        if(input.toLowerCase().equals("y")) return true;
        return false;
    }

    protected static boolean verifyCredentials(String user, String pswd) {
        if(users.contains(user)&&pass.contains(pswd)) {
            if(users.indexOf(user)==users.indexOf(pswd)){
                accessLevel = accessLevels.get(users.indexOf(user));
                return true;
            }
        }
        return false;
    }

    protected void editCase() {
        ListIterator<Case> iterator = list.listIterator();
        System.out.println("Enter the case number you would like to edit: ");
        int input = scanner.nextInt();

        for (int i = 0; i < cases.size(); i++) { 
            if (cases.contains(input)) { 
                System.out.println("What would you like to edit?");
                String editInput = scanner.next();

                switch(editInput.toLowerCase()) {
                    case "id" : 
                        System.out.println("Enter new id:");
                        Case idInput = scanner.nextInt();
                        cases.set(cases.indexOf(i), idInput);
                        break;
                    case "level" :
                        System.out.println("Enter new level:");
                        Case levelInput = scanner.next();
                        cases.set(cases.indexOf(i), levelInput);
                        break;
                    case "subject" :
                        System.out.println("Enter new subject:");
                        Case subInput = scanner.next();
                        cases.set(cases.indexOf(i), subInput);
                        break;
                    case "arresting officer" : 
                        System.out.println("Enter new arresting officer:");
                        Case arrOffInput = scanner.next();
                        cases.set(cases.indexOf(i), arrOffInput);
                        break;
                    case "date" : 
                    System.out.println("Enter new date:");
                        Case date = scanner.next();
                        cases.set(cases.indexOf(i), date);
                        break;
                    case "evidence" : 
                    System.out.println("Enter new evidence:");
                        Case evidInput = scanner.next();
                        cases.set(cases.indexOf(i), evidInput);
                        break;
                    case "description" :
                    System.out.println("Enter new description:");
                        Case descInput = scanner.next();
                        cases.set(cases.indexOf(i), descInput);
                        break; 
                    default : 
                        System.out.println("Invalid choice");
                }
            } else { 
                System.out.println("Case does not exist.");
            }
        }
    }

    protected void removeCase(String idNumber) {
        cases.remove(this.searchCases(""+idNumber));
    }

    protected static void addCredentials(String user, String pswd, String level) {
        users.add(user);
        pass.add(level);
        accessLevels.add(level);
    }

    protected void editCredentials(String user, String pswd, String level) {
        int index = users.indexOf(user);
        pass.set(index, pswd);
        accessLevels.set(index, level);
    }

    public void toMain(){
        mainFrame = new Main();
        loginFrame.setVisible(false);
        mainFrame.setVisible(true);
        mainFrame.setSize(500,500);
    }
    public static void main(String [] args) {
        try
        {
            accessLevels = new ArrayList<String>();
            users = new ArrayList<String>();
            pass = new ArrayList<String>();
            cases = new ArrayList<Case>();
            addCredentials("admin","admin","admin");
            loginFrame=new Login();
            loginFrame.setSize(300,300);
            loginFrame.setVisible(true);
            loginFrame.logins();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

