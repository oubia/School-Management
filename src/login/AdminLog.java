package login;
import DashBoard.Home;
import SinglotonConnectionnnection.Connecter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLog extends JFrame implements ActionListener {

	Connection con=Connecter.getCon();

	Container container = getContentPane();
    JLabel userLabel = new JLabel("Login");
    JLabel passwordLabel = new JLabel("Mode de Pass");
    JLabel AddminLabel = new JLabel("Administrateur");

    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("CONNECT");
    JButton resetButton = new JButton("RESET");
    JButton profButton = new JButton("Profisseur ?");

    JCheckBox showPassword = new JCheckBox("Show Password");

    String Fullname = "Mr";
    String name = "";

    public AdminLog() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.setTitle("Admin Form");
        this.setVisible(true);
        this.setBounds(10, 10, 370, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(400, 500);
        setLocationRelativeTo(null);

        
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(getBackgroundWhite());
    }
    public Color getBackgroundWhite() {
		return Color.white;
    	
    }
    public Color getBackgroundPurpol() {
    	return new java.awt.Color(63, 42, 100);
    }

    public void setLocationAndSize() {
    	AddminLabel.setBounds(140,70,100,30);

        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        profButton.setBounds(100,350,150,30);
        
        passwordField.setForeground(getBackgroundPurpol());
        userTextField.setForeground(getBackgroundPurpol());
        AddminLabel.setForeground(getBackgroundPurpol());
        loginButton.setBackground(getBackgroundPurpol());
        loginButton.setForeground(getBackgroundWhite());
        resetButton.setBackground(getBackgroundPurpol());
        resetButton.setForeground(getBackgroundWhite());
        showPassword.setBackground(getBackgroundWhite());
        userLabel.setForeground(getBackgroundPurpol());
        passwordLabel.setForeground(getBackgroundPurpol());
        profButton.setForeground(getBackgroundWhite());
        profButton.setBackground(getBackgroundPurpol());
        
        
    }

    private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addComponentsToContainer() {

    	container.add(AddminLabel);
    	container.add(userLabel);
    	container.add(passwordLabel);
    	container.add(userTextField);
    	container.add(passwordField);
    	container.add(showPassword);
    	container.add(loginButton);
    	container.add(resetButton);
    	container.add(profButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        profButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();

    		String req="select * from directeur ";
    		try {
    			PreparedStatement ps=con.prepareStatement(req);
    			ResultSet res=ps.executeQuery();
    			if(res.next()) {
    				Fullname+=" "+res.getString("NOM_D");
    				name = res.getString("NOM_D");
    				int login=res.getInt("LOG_D");
    				int password=res.getInt("PASSWRD_D");
    				if (userText.equalsIgnoreCase(Integer.toString(login)) && pwdText.equalsIgnoreCase(Integer.toString(password))) {
    	                JOptionPane.showMessageDialog(this, "Login a éte bien effectué "+ ""+name);
    	                new Home(name).setVisible(true);
    	            	dispose();

    	            } else {
    	                JOptionPane.showMessageDialog(this, "Invalid nom ou Password");
    	            }
    			}
    		}catch(SQLException sqlexeceptioe) {
    			sqlexeceptioe.printStackTrace();
    		}
            

        }
        if (e.getSource() == profButton) {
        	new ProLogin().setVisible(true);
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

