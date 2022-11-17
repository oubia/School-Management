package DashBoardProf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAOImplementation.IDEtudiantImp;

public class ActionEtudiantABS implements ActionListener {
	

    JButton AjouterAbsence = new JButton();

    
    JTextField CNETextField = new JTextField();
    JTextField AbsenceTextField = new JTextField();

    
    
    public ActionEtudiantABS(JButton JBAjoutEtudiantContentPane,JTextField CNETextField ,JTextField NomeTextField ){
    	this.AjouterAbsence = JBAjoutEtudiantContentPane;
    	this.CNETextField = CNETextField;
    	this.AbsenceTextField = NomeTextField;
    	JBAjoutEtudiantContentPane.addActionListener(this);
    }
    
    
	@Override

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == AjouterAbsence) {
			if(CNETextField.getText() != "") {
				int cne = Integer.parseInt(CNETextField.getText());
				int abs = Integer.parseInt(AbsenceTextField.getText());
				System.out.println("Ajoute clicked"+cne+"]]"+ abs);

				new IDEtudiantImp().ajoute_abs(cne, abs);
				}
			CNETextField.setText("");
			AbsenceTextField.setText("");

		}
	}
}
