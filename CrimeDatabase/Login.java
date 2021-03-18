package CrimeDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class Login extends JFrame  implements ActionListener
 {
    Driver access = new Driver();
    JButton SUBMIT;
    JPanel panel;
    JLabel label1,label2;
    final JTextField  text1,text2;
    boolean entered = false;
    String [] ret = {"",""};
    public Login()
    {
        label1 = new JLabel();
        label1.setText("Username:");
        text1 = new JTextField(15);
 
        label2 = new JLabel();
        label2.setText("Password:");
        text2 = new JPasswordField(15);
  
        SUBMIT=new JButton("SUBMIT");
   
        panel=new JPanel(new GridLayout(3,1));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(SUBMIT);
    }
    public void logins(){
        
        add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        setTitle("LOGIN FORM");
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (access.verifyCredentials(text1.getText(),text2.getText())) 
        {
            System.out.println("Welcome");
        }
        else {
            System.out.println("enter the valid username and password");
            JOptionPane.showMessageDialog(this,"Incorrect login or password",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
 }
  
 

