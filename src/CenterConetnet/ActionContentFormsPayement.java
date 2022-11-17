package CenterConetnet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import DAOImplementation.IDEtudiantImp; 

public class ActionContentFormsPayement implements ActionListener {
		
	    JButton PaymentEtudiant = new JButton();
	    JTextField CNETextField = new JTextField();
	    JTextField PaymentTextField = new JTextField();
	    
	    public ActionContentFormsPayement(JButton PaymentEtudiant,JTextField CNETextField ,JTextField PaymentTextField){
	    	this.PaymentEtudiant = PaymentEtudiant;
	    	this.CNETextField = CNETextField;
	    	this.PaymentTextField = PaymentTextField;
	    	PaymentEtudiant.addActionListener(this);
	    }
	    
	    
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == PaymentEtudiant) {
				if(CNETextField.getText() != "") {
					int cne = Integer.parseInt(CNETextField.getText());
					int payment = Integer.parseInt(PaymentTextField.getText());
					new IDEtudiantImp().ajoute_payement(cne, payment);
				}
				CNETextField.setText("");
				PaymentTextField.setText("");
			

			}
		}

	    
}

