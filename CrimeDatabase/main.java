package CrimeDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame  implements ActionListener
{
    Driver access = new Driver();
    //Main Buttons
    JButton editCase;
    JButton addCase;
    JButton deleteCase;
    JButton searchCases;
    JButton editCredentials;
    JButton addCredentials;
    JButton back;
    //Search Buttons
    JButton submitSearch;
    JLabel searchLabel;
    JTextField searchText;
    JLabel results; 
    //All Panels
    JPanel panel;
    JPanel searchPanel;
    JPanel addCasePanel;
    JPanel editCasePanel;
    JPanel deleteCasePanel;
    JPanel addCredentialsPanel;
    JPanel editCredentialsPanel;
    //Add Credentials  Buttons
    JTextField newUser;
    JTextField newPass;
    JTextField newAcessLevel;
    JLabel userLabel;
    JLabel passLabel;
    JLabel accessLabel;
    JButton addCredSubmit;
    //Delete case Buttons
    JTextField caseDelete;
    JLabel caseDeleteLabel;
    JButton caseDeleteSubmit;
    //Edit Credentials Buttons
    JTextField editUser;
    JTextField editPass;
    JTextField editLevel;
    JLabel editUserLabel;
    JLabel editPassLabel;
    JLabel editAccessLabel;
    JButton editCredSubmit;
    
    public Main()
    {
        searchCases = new JButton("Search Cases");
        addCase = new JButton("Add a Case");
        editCase = new JButton("Edit a Case");
        deleteCase = new JButton("Delete a Case");
        addCredentials = new JButton("Add a Login");
        editCredentials = new JButton("Edit Login Information");
        back = new JButton("Back");
        panel = new JPanel(new GridLayout(2,3));

        panel.add(searchCases);
        panel.add(addCase);
        panel.add(editCase);
        panel.add(deleteCase);
        panel.add(addCredentials);
        panel.add(editCredentials);

        add(panel,BorderLayout.CENTER);
        setTitle("Main Page");
        searchCases.addActionListener(this);
        addCase.addActionListener(this);
        editCase.addActionListener(this);
        deleteCase.addActionListener(this);
        addCredentials.addActionListener(this);
        editCredentials.addActionListener(this);
        back.addActionListener(this);

        submitSearch = new JButton("Submit");
        submitSearch.setActionCommand("Search Submit");
        submitSearch.addActionListener(this);

        addCredentialsPanel = new JPanel();
        addCredSubmit = new JButton("Submit");
        addCredSubmit.setActionCommand("Add Cred Submit");
        addCredSubmit.addActionListener(this);

        deleteCasePanel=new JPanel();
        caseDeleteSubmit = new JButton("Submit");
        caseDeleteSubmit.setActionCommand("Case Delete Submit");
        caseDeleteSubmit.addActionListener(this);

        searchPanel=new JPanel();
        addCasePanel = new JPanel();
        editCasePanel = new JPanel();

        editCredentialsPanel = new JPanel();
        editCredSubmit = new JButton("Submit");
        editCredSubmit.setActionCommand("Edit Cred Submit");
        editCredSubmit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        panel.setVisible(false);
        if(ae.getActionCommand().equals("Search Cases")){
            searchPanel.setVisible(true);
            addCasePanel.setVisible(false);
            editCasePanel.setVisible(false);
            deleteCasePanel.setVisible(false);
            addCredentialsPanel.setVisible(false);
            editCredentialsPanel.setVisible(false);
            search();
        }

        if(ae.getActionCommand().equals("Search Submit")){
            Case foundCase = access.searchCases(searchText.getText());
            if(foundCase != null){
                results.setText(foundCase.getDescription());
            }
            else {
                results.setText("No Case Found");
            }
            searchPanel.add(results);
        }

        if(ae.getActionCommand().equals("Add a Login")){
            searchPanel.setVisible(false);
            addCasePanel.setVisible(false);
            editCasePanel.setVisible(false);
            deleteCasePanel.setVisible(false);
            addCredentialsPanel.setVisible(true);
            editCredentialsPanel.setVisible(false);
            addLogin();
        }

        if(ae.getActionCommand().equals("Back")){
            panel.setVisible(true);
            remove(searchPanel);
            remove(addCredentialsPanel);
            add(panel);
            
            panel.setVisible(true);
            searchPanel.setVisible(false);
            addCasePanel.setVisible(false);
            editCasePanel.setVisible(false);
            deleteCasePanel.setVisible(false);
            addCredentialsPanel.setVisible(false);
            editCredentialsPanel.setVisible(false);
        }

        if(ae.getActionCommand().equals("Add Cred Submit")) {
            access.addCredentials(newUser.getText(),newPass.getText(),newAcessLevel.getText());
        }
        
        if(ae.getActionCommand().equals("Delete a Case")) {
            searchPanel.setVisible(false);
            addCasePanel.setVisible(false);
            editCasePanel.setVisible(false);
            deleteCasePanel.setVisible(true);
            addCredentialsPanel.setVisible(false);
            editCredentialsPanel.setVisible(false);
            deleteCase();
        }

        if(ae.getActionCommand().equals("Case Delete Submit")) {
            if(access.searchCases(caseDelete.getText())!=null){
                access.removeCase(caseDelete.getText());
            }
        }
        
        if(ae.getActionCommand().equals("Edit Login Information")){
            searchPanel.setVisible(false);
            addCasePanel.setVisible(false);
            editCasePanel.setVisible(false);
            deleteCasePanel.setVisible(false);
            addCredentialsPanel.setVisible(false);
            editCredentialsPanel.setVisible(true);
            editLogin();
        }

        if(ae.getActionCommand().equals("Edit Cred Submit")) {
            access.editCredentials(editUser.getText(), editPass.getText(), editLevel.getText());
        }

    }

    private void search()
    {
        searchLabel = new JLabel();
        searchLabel.setText("Search:");
        searchText = new JTextField(15);
        searchPanel = new JPanel();
        results = new JLabel();
        results.setText("");
        searchPanel.add(searchLabel);
        searchPanel.add(searchText);
        searchPanel.add(submitSearch);
        searchPanel.add(back);
        searchPanel.add(results);
        add(searchPanel);
    }

    private void addLogin() 
    {
        newUser = new JTextField(15);
        newPass = new JTextField(15);
        newAcessLevel = new JTextField(15);
        userLabel = new JLabel();
        passLabel = new JLabel();
        accessLabel = new JLabel();
        userLabel.setText("New User Name: ");
        passLabel.setText("New Password: ");
        accessLabel.setText("New Access Level: ");
        addCredentialsPanel.setLayout(new GridLayout(4,2));
        addCredentialsPanel.add(userLabel);
        addCredentialsPanel.add(newUser);
        addCredentialsPanel.add(passLabel);
        addCredentialsPanel.add(newPass);
        addCredentialsPanel.add(accessLabel);
        addCredentialsPanel.add(newAcessLevel);
        addCredentialsPanel.add(addCredSubmit);
        addCredentialsPanel.add(back);
        add(addCredentialsPanel);

    }
  
    private void deleteCase(){
        caseDelete = new JTextField(15);
        caseDeleteLabel = new JLabel();
        caseDeleteLabel.setText("ID number of Case to delete: ");
        deleteCasePanel.add(caseDeleteLabel);
        deleteCasePanel.add(caseDelete);
        deleteCasePanel.add(caseDeleteSubmit);
        deleteCasePanel.add(back);
        add(deleteCasePanel);
    }

    private void editLogin(){
        editUser = new JTextField(15);
        editPass = new JTextField(15);
        editLevel = new JTextField(15);
        editUserLabel = new JLabel();
        editPassLabel = new JLabel();
        editAccessLabel = new JLabel();
        editUserLabel.setText("Existing Username: ");
        editPassLabel.setText("New Password:");
        editAccessLabel.setText("New Access Level: ");
        editCredentialsPanel.setLayout(new GridLayout(4,2));
        editCredentialsPanel.add(editUserLabel);
        editCredentialsPanel.add(editUser);
        editCredentialsPanel.add(editPassLabel);
        editCredentialsPanel.add(editPass);
        editCredentialsPanel.add(editAccessLabel);
        editCredentials.add(editLevel);
        editCredentialsPanel.add(editCredSubmit);
        editCredentialsPanel.add(back);
        add(editCredentialsPanel);
    }
}
