package ClasseHomeCenterContent;


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

import DAOImplementation.IDClasseImp;

public class ClasseClassAdmin implements ActionListener {

	JPanel JHeader = new JPanel();
    JPanel JPcontentPnae  = new JPanel();
//    -----------------Header---------------
    JButton AjouterClass = new JButton("Ajouter");
    JButton AfficheProf = new JButton("Affichier");
    JButton AfficheEtudiant = new JButton("Etudiant");
    
//    -----------------Content---------------

//    JLabel
    JLabel ClasseLabel = new JLabel("Nom de classe");
    JLabel ClassLabelRecherch = new JLabel("Nom de classe");


//		Text Field
    JTextField ClassNome = new JTextField();
    JTextField ClassDerecherchNome = new JTextField();



//		JButtons Content pane 
    JButton JBAjoutProfContentPane = new JButton("Ajouter");
	JButton searchClasse = new JButton("Chercher par class");

//    JTabel
    JTable tab_prof;
//    Payement


    
    public ClasseClassAdmin(JPanel JHeader ,JPanel JPcontentPnae) {
    	this.JHeader = JHeader;
    	this.JPcontentPnae = JPcontentPnae;
    	AjouterClass.addActionListener(this);
		AfficheProf.addActionListener(this);
		AfficheEtudiant.addActionListener(this);
    }
    
	public void AddContentPaneTop(java.awt.event.MouseEvent evt) {
		JHeader.removeAll();
		JHeader.revalidate();
		JHeader.repaint();
		JHeader.setLayout(null);
		
		AjouterClass.setBounds(20,30,80,40);
		AjouterClass.setBackground(getBackgroundPurpol());
		AjouterClass.setForeground(getBackgroundWhite());
		

		
		AfficheProf.setBounds(120,30,80,40);
		AfficheProf.setBackground(getBackgroundPurpol());
		AfficheProf.setForeground(getBackgroundWhite());
		

		AfficheEtudiant.setBounds(220,30,100,40);
		AfficheEtudiant.setBackground(getBackgroundPurpol());
		AfficheEtudiant.setForeground(getBackgroundWhite());
		

		
		JHeader.add(AjouterClass);
		JHeader.add(AfficheProf);
		JHeader.add(AfficheEtudiant);
	}
	public void setLocationAndSizeAjoute() {
    	ClasseLabel.setBounds(50, 40, 100, 30);
    	ClassNome.setBounds(150, 40, 150, 30);
    	ClassLabelRecherch.setBounds(50, 40, 100, 30);
    	ClassDerecherchNome.setBounds(150, 40, 150, 30);
    	JBAjoutProfContentPane.setBounds(150,80,150,30);
    	searchClasse.setBounds(150,80,150,30);
	}
		
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == AjouterClass) {
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(ClasseLabel);
			JPcontentPnae.add(ClassNome);

			JBAjoutProfContentPane.setBackground(getBackgroundPurpol());
			JBAjoutProfContentPane.setForeground(getBackgroundWhite());
			setLocationAndSizeAjoute();
			JPcontentPnae.add(JBAjoutProfContentPane);
			new ACtionConetentFormsAjouter(JBAjoutProfContentPane, ClassNome);
		}
		if(event.getSource() == AfficheProf){
			//===============design the affiche page jtable
			System.out.println("clicked");
		    JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			new IDClasseImp().affiche_c(JPcontentPnae);
		
		}
		
		if(event.getSource() == AfficheEtudiant){
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			searchClasse.setBackground(getBackgroundPurpol());
			searchClasse.setForeground(getBackgroundWhite());
			setLocationAndSizeAjoute();
			JPcontentPnae.add(ClassLabelRecherch);
			JPcontentPnae.add(ClassDerecherchNome);
			JPcontentPnae.add(searchClasse);
			new Affiche_Class_P_Etud_Action(searchClasse,ClassDerecherchNome,JPcontentPnae);
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
