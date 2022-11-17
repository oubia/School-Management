package ClasseHomeCenterContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAOImplementation.IDClasseImp;

public class ACtionConetentFormsAjouter implements ActionListener {
		JButton JBAjoutProfContentPane= new JButton();

	    
	    JTextField CNITextField = new JTextField();

	    
	    
	    public ACtionConetentFormsAjouter(JButton JBAjoutProfContentPane,JTextField CNITextField ){
	    	this.JBAjoutProfContentPane = JBAjoutProfContentPane;
	    	this.CNITextField = CNITextField;
	    	JBAjoutProfContentPane.addActionListener(this);
	    }
	    
	    
		@Override

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == JBAjoutProfContentPane) {
				if(CNITextField.getText() !="") {
					String classe = CNITextField.getText();
					new IDClasseImp().ajoute_c(classe);
				}
				
				CNITextField.setText("");

			}
		}


	    
}

