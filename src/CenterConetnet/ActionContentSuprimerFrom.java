package CenterConetnet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import DAOImplementation.IDEtudiantImp; 

public class ActionContentSuprimerFrom implements ActionListener {

	JButton SuprimerEtudiant = new JButton();
    JTextField CNETextField = new JTextField();
    
    public ActionContentSuprimerFrom(JButton SuprimerEtudiant,JTextField CNETextField){
    	this.SuprimerEtudiant = SuprimerEtudiant;
    	this.CNETextField = CNETextField;
    	SuprimerEtudiant.addActionListener(this);
    }
    
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == SuprimerEtudiant) {
			if(CNETextField.getText() != "") {
				int cne = Integer.parseInt(CNETextField.getText());
				new IDEtudiantImp().supp_e(cne);
				}
			CNETextField.setText("");
		}
	}

}
