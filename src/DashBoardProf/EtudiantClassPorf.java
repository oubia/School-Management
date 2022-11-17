package DashBoardProf;


import java.awt.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import CenterConetnet.ACtionConetentFormsAjouter;
import DAOImplementation.IDEtudiantImp;

public class EtudiantClassPorf implements ActionListener {

	JPanel JHeader = new JPanel();
    JPanel JPcontentPnae  = new JPanel();
//    -----------------Header---------------
    JButton AjouterNote = new JButton("Note");
    JButton AfficheEtudiant = new JButton("Afficher");
    JButton AjouterAbsence = new JButton(" Absence");
    	
//    -----------------Content---------------

//    JLabel
    JLabel CNELabel = new JLabel("CNE");
    JLabel NoteLabel = new JLabel("Note");
    JLabel AbsenceLabel = new JLabel("Absence");
//		Text Field
    JTextField CNETextField = new JTextField();
    JTextField NoteTextField = new JTextField();
    JTextField AbsenceTextField = new JTextField();
    JTextField CNEABSTextField = new JTextField();
//		JButtons Content pane 
    JButton JBAjouterNote = new JButton("Ajouter Note");
    
//    JTabel
    JTable tab_etud;
//    Payement
	JButton JBAjouteAbsence = new JButton("Ajouter Absence");


    
    public EtudiantClassPorf(JPanel JHeader ,JPanel JPcontentPnae) {
    	this.JHeader = JHeader;
    	this.JPcontentPnae = JPcontentPnae;
    	AjouterNote.addActionListener(this);
		AfficheEtudiant.addActionListener(this);
		AjouterAbsence.addActionListener(this);

    }
    
	public void AddContentPaneTop(java.awt.event.MouseEvent evt) {
		JHeader.removeAll();
		JHeader.revalidate();
		JHeader.repaint();
		JHeader.setLayout(null);
		
		AjouterNote.setBounds(20,30,80,40);
		AjouterNote.setBackground(getBackgroundPurpol());
		AjouterNote.setForeground(getBackgroundWhite());
		


		
		AfficheEtudiant.setBounds(120,30,80,40);
		AfficheEtudiant.setBackground(getBackgroundPurpol());
		AfficheEtudiant.setForeground(getBackgroundWhite());
		
		AjouterAbsence.setBounds(220,30,100,40);
		AjouterAbsence.setBackground(getBackgroundPurpol());
		AjouterAbsence.setForeground(getBackgroundWhite());
		

		
		JHeader.add(AjouterNote);
		JHeader.add(AfficheEtudiant);
		JHeader.add(AjouterAbsence);
	}
	public void setLocationAndSizeAjoute() {
    	CNELabel.setBounds(50, 40, 100, 30);
    	NoteLabel.setBounds(50, 80, 100, 30);
    	CNETextField.setBounds(150, 40, 150, 30);
    	CNEABSTextField.setBounds(150, 40, 150, 30);
    	NoteTextField.setBounds(150, 80, 150, 30);
        AbsenceLabel.setBounds(50, 80, 100, 30);
        AbsenceTextField.setBounds(150, 80, 150, 30);
    	JBAjouterNote.setBounds(150,120,150,30);
    	JBAjouteAbsence.setBounds(150,120,150,30);

	}
		
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == AjouterNote) {
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNELabel);
			JPcontentPnae.add(CNETextField);
			JPcontentPnae.add(NoteLabel);
			JPcontentPnae.add(NoteTextField);
			JBAjouterNote.setBackground(getBackgroundPurpol());
			JBAjouterNote.setForeground(getBackgroundWhite());
			
			setLocationAndSizeAjoute();
			
			JPcontentPnae.add(JBAjouterNote);
			new ActionContentFormsNote(JBAjouterNote, CNETextField, NoteTextField);
		}
		if(event.getSource() == AfficheEtudiant){
			//===============design the affiche page jtable
			System.out.println("clicked");
			new IDEtudiantImp().affiche_e(JPcontentPnae);
		}
		if(event.getSource() == AjouterAbsence){
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNELabel);
			JPcontentPnae.add(CNEABSTextField);
			JPcontentPnae.add(AbsenceLabel);
			JPcontentPnae.add(AbsenceTextField);
			JBAjouteAbsence.setBackground(getBackgroundPurpol());
			JBAjouteAbsence.setForeground(getBackgroundWhite());
			JPcontentPnae.add(JBAjouteAbsence);

			setLocationAndSizeAjoute();

			new ActionEtudiantABS(JBAjouteAbsence, CNEABSTextField, AbsenceTextField);
			
		}
		
		
	}
	public void AddContentPaneCentre() {
		
	}
	private Color getBackgroundWhite() {
		return Color.white;
	}
	public Color getBackgroundPurpol() {
    	return new java.awt.Color(63, 42, 100);
    }
}
