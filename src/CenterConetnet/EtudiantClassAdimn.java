package CenterConetnet;


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
import DAOImplementation.IDEtudiantImp; 

public class EtudiantClassAdimn implements ActionListener {

	JPanel JHeader = new JPanel();
    JPanel JPcontentPnae  = new JPanel();
//    -----------------Header---------------
    JButton AjouterEtudiant = new JButton("Ajouter");
    JButton AfficheEtudiant = new JButton("Aficher");
    JButton PaymentEtudiant = new JButton("Payment");
    JButton SupprimerEtudiant = new JButton("Supprimer");
    
    		
//    -----------------Content---------------

//    JLabel
    JLabel CNELabel = new JLabel("CNE");
    JLabel NomeLabel = new JLabel("Nome");
    JLabel PrenomLabel = new JLabel("Prenom");
    JLabel ClassLabel = new JLabel("Class");
//		Text Field
    JTextField CNETextField = new JTextField();
    JTextField NomeTextField = new JTextField();
    JTextField PrenomTextField = new JTextField();
    JTextField ClassTextField = new JTextField();

//		JButtons Content pane 
    JButton JBAjoutEtudiantContentPane = new JButton("Ajouter");
    
//    JTabel
    JTable tab_etud;
//    Payement
    JTextField PaymentTextField = new JTextField();
	JButton AjoutePaymentEtudiant = new JButton("Ajouter Payment");
	JLabel PaymentLabel = new JLabel("Payment");
	JButton SuprimerEtudiantButton = new JButton("Supprimer Etudiant");

    
    public EtudiantClassAdimn(JPanel JHeader ,JPanel JPcontentPnae) {
    	this.JHeader = JHeader;
    	this.JPcontentPnae = JPcontentPnae;
    	AjouterEtudiant.addActionListener(this);
		AfficheEtudiant.addActionListener(this);
		PaymentEtudiant.addActionListener(this);
		SupprimerEtudiant.addActionListener(this);
    }
    
	public void AddContentPaneTop(java.awt.event.MouseEvent evt) {
		JHeader.removeAll();
		JHeader.revalidate();
		JHeader.repaint();
		JHeader.setLayout(null);
		
		AjouterEtudiant.setBounds(20,30,80,40);
		AjouterEtudiant.setBackground(getBackgroundPurpol());
		AjouterEtudiant.setForeground(getBackgroundWhite());
		
		AjoutePaymentEtudiant.setBounds(20,30,80,40);
		AjoutePaymentEtudiant.setBackground(getBackgroundPurpol());
		AjoutePaymentEtudiant.setForeground(getBackgroundWhite());

		
		AfficheEtudiant.setBounds(120,30,80,40);
		AfficheEtudiant.setBackground(getBackgroundPurpol());
		AfficheEtudiant.setForeground(getBackgroundWhite());
		
		PaymentEtudiant.setBounds(220,30,100,40);
		PaymentEtudiant.setBackground(getBackgroundPurpol());
		PaymentEtudiant.setForeground(getBackgroundWhite());
		
		SupprimerEtudiant.setBounds(340,30,100,40);
		SupprimerEtudiant.setBackground(getBackgroundPurpol());
		SupprimerEtudiant.setForeground(getBackgroundWhite());
		
		SuprimerEtudiantButton.setBackground(getBackgroundPurpol());
		SuprimerEtudiantButton.setForeground(getBackgroundWhite());
		
		JHeader.add(AjouterEtudiant);
		JHeader.add(AfficheEtudiant);
		JHeader.add(PaymentEtudiant);
		JHeader.add(SupprimerEtudiant);
	}
	public void setLocationAndSizeAjoute() {
    	CNELabel.setBounds(50, 40, 100, 30);
    	NomeLabel.setBounds(50, 80, 100, 30);
    	CNETextField.setBounds(150, 40, 150, 30);
    	NomeTextField.setBounds(150, 80, 150, 30);
    	PrenomLabel.setBounds(50, 120, 100, 30);
        PrenomTextField.setBounds(150, 120, 150, 30);
        ClassLabel.setBounds(50, 160, 100, 30);
        ClassTextField.setBounds(150, 160, 150, 30);
    	JBAjoutEtudiantContentPane.setBounds(150,200,150,30);
    	
    	PaymentLabel.setBounds(50, 80, 100, 30);
    	PaymentTextField.setBounds(150, 80, 150, 30);
    	AjoutePaymentEtudiant.setBounds(150,120,150,30);
    	
    	SuprimerEtudiantButton.setBounds(150,80,150,30);
	}
		
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == AjouterEtudiant) {
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNELabel);
			JPcontentPnae.add(CNETextField);
			JPcontentPnae.add(NomeLabel);
			JPcontentPnae.add(NomeTextField);
			JPcontentPnae.add(PrenomLabel);
			JPcontentPnae.add(PrenomTextField);
			JPcontentPnae.add(ClassLabel);
			JPcontentPnae.add(ClassTextField);
			JBAjoutEtudiantContentPane.setBackground(getBackgroundPurpol());
			JBAjoutEtudiantContentPane.setForeground(getBackgroundWhite());
			setLocationAndSizeAjoute();
			JPcontentPnae.add(JBAjoutEtudiantContentPane);
			new ACtionConetentFormsAjouter(JBAjoutEtudiantContentPane, CNETextField, NomeTextField, PrenomTextField, ClassTextField);
		}
		if(event.getSource() == AfficheEtudiant){
			//===============design the affiche page jtable
			System.out.println("clicked");
			new IDEtudiantImp().affiche_e(JPcontentPnae);
		}
		if(event.getSource() == PaymentEtudiant){
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNELabel);
			JPcontentPnae.add(CNETextField);
			JPcontentPnae.add(PaymentLabel);
			JPcontentPnae.add(PaymentTextField);
			setLocationAndSizeAjoute();

			JPcontentPnae.add(AjoutePaymentEtudiant);
			new ActionContentFormsPayement(AjoutePaymentEtudiant,CNETextField,PaymentTextField);
			
		}
		if(event.getSource() == SupprimerEtudiant){
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNELabel);
			JPcontentPnae.add(CNETextField);
			JPcontentPnae.add(SuprimerEtudiantButton);
			
			new ActionContentSuprimerFrom(SuprimerEtudiantButton, CNETextField);
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
