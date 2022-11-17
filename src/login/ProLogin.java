package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import DashBoard.Home;
import DashBoardProf.HomeProf;
import SinglotonConnectionnnection.Connecter;

public class ProLogin extends JFrame implements ActionListener {
	Connection con=Connecter.getCon();

	Container container = getContentPane();
    JLabel userLabel = new JLabel("Login");
    JLabel passwordLabel = new JLabel("Mode de Pass");
    JLabel PrfLabel = new JLabel("Profisseur");

    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("CONNECT");
    JButton resetButton = new JButton("RESET");
    JButton AdminButton = new JButton("Admin ?");

    JCheckBox showPassword = new JCheckBox("Show Password");
    

    String Fullname = "Mr";
    String name = "";

    public ProLogin() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.setTitle("Profisseur Form");
        this.setVisible(true);
        this.setBounds(10, 10, 370, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(400, 500);
        setLocationRelativeTo(null);

        
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(getBackgroundPurpol());
    }
    public Color getBackgroundWhite() {
		return Color.white;
    	
    }
    public Color getBackgroundPurpol() {
    	return new java.awt.Color(63, 42, 100);
    }

    public void setLocationAndSize() {
    	PrfLabel.setBounds(140,70,100,30);

        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        AdminButton.setBounds(100,350,150,30);
        
        passwordField.setForeground(getBackgroundPurpol());
        userTextField.setForeground(getBackgroundPurpol());
        PrfLabel.setForeground(getBackgroundWhite());
        loginButton.setBackground(getBackgroundWhite());
        loginButton.setForeground(getBackgroundPurpol());
        resetButton.setBackground(getBackgroundWhite());
        resetButton.setForeground(getBackgroundPurpol());
        showPassword.setBackground(getBackgroundPurpol());
        showPassword.setForeground(getBackgroundWhite());
        userLabel.setForeground(getBackgroundWhite());
        passwordLabel.setForeground(getBackgroundWhite());
        AdminButton.setForeground(getBackgroundPurpol());
        AdminButton.setBackground(getBackgroundWhite());
    }

    public void addComponentsToContainer() {

    	container.add(PrfLabel);
    	container.add(userLabel);
    	container.add(passwordLabel);
    	container.add(userTextField);
    	container.add(passwordField);
    	container.add(showPassword);
    	container.add(loginButton);
    	container.add(resetButton);
    	container.add(AdminButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        AdminButton.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            try{
                String req="select * from Professeur ";
                PreparedStatement ps=con.prepareStatement(req);
                ResultSet res=ps.executeQuery();
            	while(res.next()) {
            		Fullname+=" "+res.getString("NOM_P");
            		
            		Fullname+=" "+res.getString("PRENOM_P");
            		this.name = res.getString("NOM_P");
            		int log_p = res.getInt("log_p");
                    int passwrd_p = res.getInt("passwrd_p");    
                    if (userText.equalsIgnoreCase(Integer.toString(log_p)) && pwdText.equalsIgnoreCase(Integer.toString(passwrd_p))) {
                        JOptionPane.showMessageDialog(this, "Login a éte bien effectué "+ ""+name);
                        new HomeProf(this.name).setVisible(true);
                    	dispose();
                    }
                }
            }catch(SQLException SQLExceptione){
                System.out.println("Erreur !!:"+SQLExceptione);
            }
            
        }
        if (e.getSource() == AdminButton) {
        	new AdminLog().setVisible(true);
        	dispose();
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
    

}
