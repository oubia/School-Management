package CenterConetnet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import DAOImplementation.IDEtudiantImp; 
public class ACtionConetentFormsAjouter implements ActionListener {
		JButton JBAjoutEtudiantContentPane= new JButton();
	    JButton AfficheEtudiant = new JButton();
	    JButton PaymentEtudiant = new JButton();
	    JButton SupprimerEtudiant = new JButton();
	    
	    JTextField CNETextField = new JTextField();
	    JTextField NomeTextField = new JTextField();
	    JTextField PrenomTextField = new JTextField();
	    JTextField ClassTextField = new JTextField();
	    
	    
	    public ACtionConetentFormsAjouter(JButton JBAjoutEtudiantContentPane,
	    		JTextField CNETextField ,JTextField NomeTextField,
	    		JTextField PrenomTextField,JTextField ClassTextField 
	    ){
	    	this.JBAjoutEtudiantContentPane = JBAjoutEtudiantContentPane;
	    	this.CNETextField = CNETextField;
	    	this.NomeTextField = NomeTextField;
	    	this.PrenomTextField = PrenomTextField;
	    	this.ClassTextField = ClassTextField;
	    	JBAjoutEtudiantContentPane.addActionListener(this);
	    }
	    
	    
		@Override

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == JBAjoutEtudiantContentPane) {
				if(CNETextField.getText() != "") {
					int cne = Integer.parseInt(CNETextField.getText());
					String nome = NomeTextField.getText();
					String prenom = PrenomTextField.getText();
					String classe = ClassTextField.getText();
					new IDEtudiantImp().ajoute_e(nome, prenom, cne, classe); 
				}
				
				CNETextField.setText("");
				NomeTextField.setText("");
				PrenomTextField.setText("");
				ClassTextField.setText("");

			}
		}

	    
}

