package CrimeDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    //Add Case Buttons
    JTextField caseId;
    JTextField crimeLevel;
    JTextField subjectName;
    JTextField subjectAge;
    JTextField arrestingOfficerName;
    JTextField arrestingOfficerAge;
    JTextField arrestingOfficerArrests;
    JTextField date;
    ArrayList <JTextField> evidenceType;
    ArrayList <JTextField> evidenceDescription;
    int evidenceCounter = 1;
    JTextField description;
    JLabel labelcaseId;
    JLabel labelcrimeLevel;
    JLabel labelsubjectName;
    JLabel labelsubjectAge;
    JLabel labelarrestingOfficerName;
    JLabel labelarrestingOfficerAge;
    JLabel labelarrestingOfficerArrests;
    JLabel labeldate;
    JLabel labelevidenceType;
    JLabel labelevidenceDescription;
    JLabel labeldescription;
    JButton addEvidence;
    JButton addCaseSubmit;
    
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
        editCasePanel = new JPanel();

        editCredentialsPanel = new JPanel();
        editCredSubmit = new JButton("Submit");
        editCredSubmit.setActionCommand("Edit Cred Submit");
        editCredSubmit.addActionListener(this);

        addCasePanel = new JPanel();
        addCaseSubmit = new JButton("Submit");
        addCaseSubmit.setActionCommand("Add Case Submit");
        addCaseSubmit.addActionListener(this);
        addEvidence = new JButton("More Evidence");
        addEvidence.setActionCommand("Add Evidence Submit");
        addEvidence.addActionListener(this);

        panel.setVisible(true);
        searchPanel.setVisible(false);
        addCasePanel.setVisible(false);
        editCasePanel.setVisible(false);
        deleteCasePanel.setVisible(false);
        addCredentialsPanel.setVisible(false);
        editCredentialsPanel.setVisible(false);
        add(panel);
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

        if(ae.getActionCommand().equals("Add a Case")){
            searchPanel.setVisible(false);
            addCasePanel.setVisible(true);
            editCasePanel.setVisible(false);
            deleteCasePanel.setVisible(false);
            addCredentialsPanel.setVisible(false);
            editCredentialsPanel.setVisible(false);
            addCase();
        }
    
        if(ae.getActionCommand().equals("Add Evidence Submit")){
            evidenceType.add(new JTextField());
            evidenceDescription.add(new JTextField());
            evidenceCounter=evidenceType.size()-1;
            addCasePanel.remove(addCaseSubmit);
            addCasePanel.remove(back);
            addCasePanel.remove(addEvidence);
            addCasePanel.add(labelevidenceType);
            addCasePanel.add(evidenceType.get(evidenceCounter));
            addCasePanel.add(labelevidenceDescription);
            addCasePanel.add(evidenceDescription.get(evidenceCounter));
            addCasePanel.add(addEvidence);
            addCasePanel.add(addCaseSubmit);
            addCasePanel.add(back);
            addCasePanel.updateUI();
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

    private void addCase(){
        caseId = new JTextField(15);
        crimeLevel = new JTextField(15);
        subjectName = new JTextField(15);
        subjectAge = new JTextField(15);
        arrestingOfficerName = new JTextField(15);
        arrestingOfficerAge = new JTextField(15);
        arrestingOfficerArrests = new JTextField(15);
        date = new JTextField(15);
        description = new JTextField(45);
        evidenceType = new ArrayList <JTextField>();
        evidenceDescription = new ArrayList <JTextField>();
        evidenceType.add(new JTextField(15));
        evidenceDescription.add(new JTextField(15));
        labelcaseId = new JLabel();
        labelcrimeLevel = new JLabel();
        labelsubjectName = new JLabel();
        labelsubjectAge = new JLabel();
        labelarrestingOfficerName = new JLabel();
        labelarrestingOfficerAge = new JLabel();
        labelarrestingOfficerArrests = new JLabel();
        labeldate = new JLabel();
        labelevidenceType = new JLabel();
        labelevidenceDescription = new JLabel();
        labeldescription = new JLabel();
        labelcaseId.setText("New Case ID Number: ");
        labelcrimeLevel.setText("New Case Crime Level: ");
        labelsubjectName.setText("New Case Subject Name: ");
        labelsubjectAge.setText("New Case Subject Age: ");
        labelarrestingOfficerName.setText("New Case Arresting Officer Name: ");
        labelarrestingOfficerAge.setText("New Case Arresting Officer Age: ");
        labelarrestingOfficerArrests.setText("New Case Arresting Officer Arrests: ");
        labeldate.setText("New Case Date: ");
        labelevidenceType.setText("New Case Evidence Type: ");
        labelevidenceDescription.setText("New Case Evidence Description: ");
        labeldescription.setText("New Case Description: ");
        addCasePanel.setLayout(new GridLayout(14,2));
        addCasePanel.add(labelcaseId);
        addCasePanel.add(caseId);
        addCasePanel.add(labelcrimeLevel);
        addCasePanel.add(crimeLevel);
        addCasePanel.add(labeldate);
        addCasePanel.add(date);
        addCasePanel.add(labeldescription);
        addCasePanel.add(description);
        addCasePanel.add(labelsubjectName);
        addCasePanel.add(subjectName);
        addCasePanel.add(labelsubjectAge);
        addCasePanel.add(subjectAge);
        addCasePanel.add(labelarrestingOfficerName);
        addCasePanel.add(arrestingOfficerName);
        addCasePanel.add(labelarrestingOfficerAge);
        addCasePanel.add(arrestingOfficerAge);
        addCasePanel.add(labelarrestingOfficerArrests);
        addCasePanel.add(arrestingOfficerArrests);
        for(int i = 0; i<evidenceCounter;i++){
            addCasePanel.add(labelevidenceType);
            addCasePanel.add(evidenceType.get(i));
            addCasePanel.add(labelevidenceDescription);
            addCasePanel.add(evidenceDescription.get(i));
        }
        addCasePanel.add(addEvidence);
        addCasePanel.add(addCaseSubmit);
        addCasePanel.add(back);
        add(addCasePanel);
    }
}
