package ClasseHomeCenterContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAOImplementation.IDClasseImp;

public class Affiche_Class_P_Etud_Action implements ActionListener {
	JButton Affiche_par_etudiant= new JButton();

    
    JTextField CNITextField = new JTextField();
    JPanel JPcontentPnae = new JPanel();
    
    
    public Affiche_Class_P_Etud_Action(JButton Affiche_par_etudiant,JTextField CNITextField,JPanel JPcontentPnae ){
    	this.JPcontentPnae = JPcontentPnae;
    	this.Affiche_par_etudiant = Affiche_par_etudiant;
    	this.CNITextField = CNITextField;
    	Affiche_par_etudiant.addActionListener(this);
    }
    
    
	@Override

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == Affiche_par_etudiant) {
			if(CNITextField.getText() !="") {
				String classe = CNITextField.getText();
				JPcontentPnae.add(new IDClasseImp().aff_etud_c(classe));
			}
			
			CNITextField.setText("");

		}
	}



}
