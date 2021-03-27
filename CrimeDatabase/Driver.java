package CrimeDatabase;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Year;


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

    protected void searchCases() {
        Cases cases = Cases.getInstance();
        ArrayList<Case> caseList = cases.getCases();  

        System.out.println("Search through cases:");
        String input = scanner.nextLine();
        for (int i = 0; i < caseList.size(); i++) { 
            if (input.equals(caseList.get(i).getLevel()) || input.contains(caseList.get(i).getDate())) { 
                System.out.print(caseList.get(i));
            } else { 
                System.out.println("No matches.");
                break;
            }
        }
    }

    protected boolean addCase() {
        System.out.println("Would you like to add a new case (Y/N)?");
        String input = scanner.next();
        
        if (input.equalsIgnoreCase("y")) return true;
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
        Cases cases = Cases.getInstance();
        ArrayList<Case> caseList = cases.getCases();

        System.out.println("Enter the case id you would like to edit: ");
        int input = scanner.nextInt();

        for (int i = 0; i < caseList.size(); i++) { 
            if (caseList.contains(input)) { 
                System.out.println("What would you like to edit?");
                String editInput = scanner.next();

                switch(editInput.toLowerCase()) {
                    case "id" : 
                        System.out.println("Enter new id:");
                        int idInput = scanner.nextInt();
                        caseList.get(i).setId(idInput);
                        break;
                    case "level" :
                        System.out.println("Enter new level:");
                        String levelInput = scanner.next();
                        caseList.get(i).setLevel(levelInput);
                        break;
                    case "date" : 
                        System.out.println("Enter new date:");
                        String date = scanner.next();
                        caseList.get(i).setDate(date);
                        break;
                    case "evidence" : 
                        System.out.println("How much evidence would you like to enter?");
                        int numEvid = scanner.nextInt();
                        String[] arr = new String[numEvid];
                        System.out.println("Enter new evidence: ");
                        for (int j = 0; j < arr.length; j++) { 
                            arr[j] = scanner.nextLine();
                            caseList.get(i).setEvidence(arr);
                        }
                        break;
                    case "witnesses" : 
                        System.out.println("How many witnesses would you like to enter?");
                        int numWit = scanner.nextInt();
                        String[] witArr = new String[numWit];
                        System.out.println("Enter new witnesses: ");
                        for (int j = 0; j < witArr.length; j++) { 
                            witArr[j] = scanner.nextLine();
                            caseList.get(i).setEvidence(witArr);
                        }
                        break;
                    case "victimInfo" : 
                        System.out.println("How many victims would you like to enter?");
                        int numVic = scanner.nextInt();
                        String[] vicArr = new String[numVic];
                        System.out.println("Enter new victims: ");
                        for (int j = 0; j < vicArr.length; j++) { 
                            vicArr[j] = scanner.nextLine();
                            caseList.get(i).setEvidence(vicArr);
                        }
                        break;
                    case "description" :
                        System.out.println("Enter new description:");
                        String descInput = scanner.next();
                        caseList.get(i).setDescription(descInput);
                        break; 
                    default : 
                        System.out.println("Invalid choice");
                }
            } else { 
                System.out.println("Case does not exist.");
            }
        }
    }

    private String getField(String prompt) { 
        System.out.print(prompt  + ": ");
        return scanner.next();
    }

    private int getNumField(String word) { 
        System.out.print(word +": ");
        return scanner.nextInt();
    }

    public boolean addAccount() { 
        System.out.println("Would you like to Create an Account?");
        String input = scanner.next();
        if (input.toLowerCase().trim().equals("y")) { 
            return true;
        } else {
        return false;
        }
    }

    public boolean deleteAcc() { 
        System.out.println("Delete Account?");
        String input = scanner.next();
        if (input.toLowerCase().trim().equals("y")) { 
            return true;
        } else {
            return false;
        }
    }

    public void removeOfficer() { 
        Officers officers = Officers.getInstance();
        ArrayList<Officer> list = officers.getOfficers();

        System.out.println("Enter account ID:");
        int ID = scanner.nextInt();
        System.out.println("Enter account username:");
        String userName = scanner.next();
        System.out.println("Enter account password:");
        String pass = scanner.next();
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        System.out.println("Enter badge ID:");
        String badgeID = scanner.next();

        if(list.contains(new Officer(ID, userName, pass, name, age, badgeID))) { 
            list.remove(new Officer(ID, userName, pass, name, age, badgeID));
            System.out.println("Account removed");
        }
        else { 
            System.out.println("Account with those credentials does not exist");
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

    public void play() { 
        System.out.println("edit:");
        editCase();
       /* Officers officers = Officers.getInstance();
        displayAccounts();
        
        while(removeAccount()) { 
            remove();
        }
        System.out.println("NEW LIST");
        displayAccounts();
        System.out.println("\nExiting");*/

        
    }

    private void checkLogin() { 
        Officers officers = Officers.getInstance();
        ArrayList<Officer> list = officers.getOfficers();

        System.out.println("Enter account ID:");
        int logID = scanner.nextInt();
        System.out.println("Enter account username:");
        String logUsername = scanner.next();
        System.out.println("Enter account password:");
        String logPass = scanner.next();
        System.out.println("Enter name:");
        String logName = scanner.next();
        System.out.println("Enter age:");
        int logAge = scanner.nextInt();
        System.out.println("Enter badge ID:");
        String logBadgeID = scanner.next();

        Officer offInstance = new Officer(logID, logUsername,logPass,logName,logAge,logBadgeID);
        

        int size = list.size();

        for (int i  = 0; i < size; i++) { 
            if(offInstance.equals(list.get(i).getUser())) { 
                System.out.println("Logged in!");
            } else { 
                System.out.println("Incorrect User/Password!");
            }
        }
    }

    public void displayAccounts(){
        Officers officers = Officers.getInstance();
        ArrayList<Officer> list = officers.getOfficers();

        for (Officer officer : list) { 
            System.out.println(officer.getUser()+officer.getPass()+officer.getName()+officer.getAge()+officer.getBadgeID());
        }
    }

    public static void main(String [] args) {
       /* Driver d = new Driver();
        d.play();*/
        
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

