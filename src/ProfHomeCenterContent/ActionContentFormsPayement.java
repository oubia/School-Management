package ProfHomeCenterContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAOImplementation.IDProfesseurImp;

public class ActionContentFormsPayement implements ActionListener {
		
	    JButton PaymentProf = new JButton();
	    JTextField CNETextField = new JTextField();
	    JTextField PaymentTextField = new JTextField();
	    
	    public ActionContentFormsPayement(JButton PaymentProf,JTextField CNETextField ,JTextField PaymentTextField){
	    	this.PaymentProf = PaymentProf;
	    	this.CNETextField = CNETextField;
	    	this.PaymentTextField = PaymentTextField;
	    	PaymentProf.addActionListener(this);
	    }
	    
	    
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == PaymentProf) {
				if(CNETextField.getText() !="") {
					int cne = Integer.parseInt(CNETextField.getText());
					int payment = Integer.parseInt(PaymentTextField.getText());

					new IDProfesseurImp().ajoute_salaire(cne,payment);
				}
				System.out.println("Ajoute clicked");
				CNETextField.setText("");
				PaymentTextField.setText("");
			

			}
		}

	    
}

