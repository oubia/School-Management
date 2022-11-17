package ProfHomeCenterContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAOImplementation.IDProfesseurImp;

public class ACtionConetentFormsAjouter implements ActionListener {
		JButton JBAjoutProfContentPane= new JButton();
	    JButton AfficheProf = new JButton();
	    JButton PaymentProf = new JButton();
	    JButton SupprimerProf = new JButton();
	    
	    JTextField CNETextField = new JTextField();
	    JTextField NomeTextField = new JTextField();
	    JTextField PrenomTextField = new JTextField();
	    
	    
	    public ACtionConetentFormsAjouter(JButton JBAjoutProfContentPane,
	    		JTextField CNETextField ,JTextField NomeTextField,
	    		JTextField PrenomTextField 
	    ){
	    	this.JBAjoutProfContentPane = JBAjoutProfContentPane;
	    	this.CNETextField = CNETextField;
	    	this.NomeTextField = NomeTextField;
	    	this.PrenomTextField = PrenomTextField;
	    	JBAjoutProfContentPane.addActionListener(this);
	    }
	    
	    
		@Override

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == JBAjoutProfContentPane) {
				System.out.println("Ajoute clicked");
				if(CNETextField.getText() !="") {
					int cne = Integer.parseInt(CNETextField.getText());
					String nom =NomeTextField.getText();
					String prenom = PrenomTextField.getText();
					new IDProfesseurImp().ajoute_p(cne, nom, prenom);
				}
				CNETextField.setText("");
				NomeTextField.setText("");
				PrenomTextField.setText("");

			}
		}

	    
}

