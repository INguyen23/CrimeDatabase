package CrimeDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame  implements ActionListener
{
    Driver access = new Driver();
    JButton editCase;
    JButton addCase;
    JButton deleteCase;
    JButton searchCases;
    JButton editCredentials;
    JButton addCredentials;
    JPanel panel;
    
    public Main(){
        searchCases = new JButton("Search Cases");
        addCase = new JButton("Add a Case");
        editCase = new JButton("Edit a Case");
        deleteCase = new JButton("Delete a Case");
        addCredentials = new JButton("Add a Login");
        editCredentials = new JButton("Edit Login Information");
        panel = new JPanel(new GridLayout(2,3));

        panel.add(searchCases);
        panel.add(addCase);
        panel.add(editCase);
        panel.add(deleteCase);
        panel.add(addCredentials);
        panel.add(editCredentials);

        add(panel,BorderLayout.CENTER);
        setTitle("Main Page");

    }

    public void actionPerformed(ActionEvent ae) {
        
        
    }
    
}
