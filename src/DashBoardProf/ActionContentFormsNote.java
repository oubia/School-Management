package DashBoardProf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAOImplementation.IDEtudiantImp;

public class ActionContentFormsNote implements ActionListener {
		
	JButton AjouterNote= new JButton();

    
    JTextField CNETextField = new JTextField();
    JTextField NoteTextField = new JTextField();

    
    
    public ActionContentFormsNote(JButton JBAjoutEtudiantContentPane,JTextField CNETextField ,JTextField NomeTextField ){
    	this.AjouterNote = JBAjoutEtudiantContentPane;
    	this.CNETextField = CNETextField;
    	this.NoteTextField = NomeTextField;
    	JBAjoutEtudiantContentPane.addActionListener(this);
    }
    
    
	@Override

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == AjouterNote) {
			if(CNETextField.getText() != "") {
				int cne = Integer.parseInt(CNETextField.getText());
				float note = Float.parseFloat(NoteTextField.getText());
				new IDEtudiantImp().ajoute_note(cne, note);
			}
			System.out.println("Ajoute clicked");
			CNETextField.setText("");
			NoteTextField.setText("");

		}
	
	}

	    
}

