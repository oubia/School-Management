package ProfHomeCenterContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAOImplementation.IDProfesseurImp;

public class ActionContentSuprimerFrom implements ActionListener {

	JButton SuprimerProf = new JButton();
    JTextField CNETextField = new JTextField();
    
    public ActionContentSuprimerFrom(JButton SuprimerProf,JTextField CNETextField){
    	this.SuprimerProf = SuprimerProf;
    	this.CNETextField = CNETextField;
    	SuprimerProf.addActionListener(this);
    }
    
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == SuprimerProf) {
			if(CNETextField.getText() != "") {
				int cne = Integer.parseInt(CNETextField.getText());
				new IDProfesseurImp().supp_p(cne);
			}
			System.out.println("Ajoute clicked");
			CNETextField.setText("");
		}
	}

}
