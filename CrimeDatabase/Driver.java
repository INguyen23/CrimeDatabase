package CrimeDatabase;

import java.util.ArrayList;
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

    private void editInfo() {

    }

    private Case seachCases() {
        System.out.println("Search through cases: ");
        String input = scanner.next();
        
        for(Case case1 : cases) {
            if ((""+case1.getId()).equalsIgnoreCase(input) || (case1.getLevel().getcrimeType()).equalsIgnoreCase(input) || (case1.getSubject().getName()).equalsIgnoreCase(input) 
            || case1.getDate().equalsIgnoreCase(input) || case1.getEvidence().contains(input) || case1.getDescription().equalsIgnoreCase(input)) { 
                return case1;
            }
        }   
    }

    private boolean addCase() {
        System.out.println("Would you like to add a new case (Y/N)?");
        String input = scanner.next();
        
        if(input.toLowerCase().equals("y")) return true;
        return false;
    }

    public static boolean verifyCredentials(String user, String pswd) {
        if(users.contains(user)&&pass.contains(pswd)) {
            if(users.indexOf(user)==users.indexOf(pswd)){
                accessLevel = accessLevels.get(users.indexOf(user));
                return true;
            }
        }
        return false;
    }

    private void editCase() {

    }

    private void removeCase() {

    }

    private static void addCredentials(String user, String pswd, String level) {
        users.add(user);
        pass.add(level);
        accessLevels.add(level);
    }

    private void editCredentials() {
        
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

