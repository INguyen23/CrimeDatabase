package CrimeDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class Login extends JFrame  implements ActionListener
 {
    Driver access = new Driver();
    JButton SUBMIT;
    JPanel panel;
    JLabel userLabel,passLabel;
    final JTextField  userText,passText;
    public Login()
    {
        userLabel = new JLabel();
        userLabel.setText("Username:");
        userText = new JTextField(15);
 
        passLabel = new JLabel();
        passLabel.setText("Password:");
        passText = new JPasswordField(15);
  
        SUBMIT=new JButton("SUBMIT");
   
        panel=new JPanel(new GridLayout(3,1));
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(SUBMIT);
    }
    public void logins(){
        
        add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        setTitle("LOGIN FORM");
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (access.verifyCredentials(userText.getText(),passText.getText())) 
        {
            JOptionPane.showMessageDialog(this,"Welcome",
            "Login Success",JOptionPane.INFORMATION_MESSAGE);
            access.toMain();
        }
        else {
            System.out.println("enter the valid username and password");
            JOptionPane.showMessageDialog(this,"Incorrect login or password",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
 }
  
 

