package CrimeDatabase;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Driver extends JFrame {
    private static String accessLevel;
    private static ArrayList<Case> cases;
    private static ArrayList<String> users;
    private static ArrayList<String> pass;
    private static ArrayList<String> accessLevels;
    private static Login loginFrame;

    private void editInfo() {

    }

    private void seachCases() {

    }

    private void addCase() {

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