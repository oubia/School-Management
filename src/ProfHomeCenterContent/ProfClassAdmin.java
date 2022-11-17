package ProfHomeCenterContent;


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

import DAOImplementation.IDProfesseurImp;

public class ProfClassAdmin implements ActionListener {

	JPanel JHeader = new JPanel();
    JPanel JPcontentPnae  = new JPanel();
//    -----------------Header---------------
    JButton AjouterProf = new JButton("Ajouter");
    JButton AfficheProf = new JButton("Aficher");
    JButton PaymentProf = new JButton("Payment");
    JButton SupprimerProf = new JButton("Supprimer");
    
    		
//    -----------------Content---------------

//    JLabel
    JLabel CNILabel = new JLabel("CNI");
    JLabel NomeLabel = new JLabel("Nome");
    JLabel PrenomLabel = new JLabel("Prenom");
//		Text Field
    JTextField CNETextField = new JTextField();
    JTextField NomeTextField = new JTextField();
    JTextField PrenomTextField = new JTextField();

//		JButtons Content pane 
    JButton JBAjoutProfContentPane = new JButton("Ajouter");
    
//    JTabel
    JTable tab_prof;
//    Payement
    JTextField PaymentTextField = new JTextField();
	JButton AjoutePaymentProf = new JButton("Ajouter Payment");
	JLabel PaymentLabel = new JLabel("Payment");
	JButton SuprimerProfButton = new JButton("Supprimer prof");

    
    public ProfClassAdmin(JPanel JHeader ,JPanel JPcontentPnae) {
    	this.JHeader = JHeader;
    	this.JPcontentPnae = JPcontentPnae;
    	AjouterProf.addActionListener(this);
		AfficheProf.addActionListener(this);
		PaymentProf.addActionListener(this);
		SupprimerProf.addActionListener(this);
    }
    
	public void AddContentPaneTop(java.awt.event.MouseEvent evt) {
		JHeader.removeAll();
		JHeader.revalidate();
		JHeader.repaint();
		JHeader.setLayout(null);
		
		AjouterProf.setBounds(20,30,80,40);
		AjouterProf.setBackground(getBackgroundPurpol());
		AjouterProf.setForeground(getBackgroundWhite());
		
		AjoutePaymentProf.setBounds(20,30,80,40);
		AjoutePaymentProf.setBackground(getBackgroundPurpol());
		AjoutePaymentProf.setForeground(getBackgroundWhite());

		
		AfficheProf.setBounds(120,30,80,40);
		AfficheProf.setBackground(getBackgroundPurpol());
		AfficheProf.setForeground(getBackgroundWhite());
		
		PaymentProf.setBounds(220,30,100,40);
		PaymentProf.setBackground(getBackgroundPurpol());
		PaymentProf.setForeground(getBackgroundWhite());
		
		SupprimerProf.setBounds(340,30,100,40);
		SupprimerProf.setBackground(getBackgroundPurpol());
		SupprimerProf.setForeground(getBackgroundWhite());
		
		SuprimerProfButton.setBackground(getBackgroundPurpol());
		SuprimerProfButton.setForeground(getBackgroundWhite());
		
		JHeader.add(AjouterProf);
		JHeader.add(AfficheProf);
		JHeader.add(PaymentProf);
		JHeader.add(SupprimerProf);
	}
	public void setLocationAndSizeAjoute() {
    	CNILabel.setBounds(50, 40, 100, 30);
    	NomeLabel.setBounds(50, 80, 100, 30);
    	CNETextField.setBounds(150, 40, 150, 30);
    	NomeTextField.setBounds(150, 80, 150, 30);
    	PrenomLabel.setBounds(50, 120, 100, 30);
        PrenomTextField.setBounds(150, 120, 150, 30);

    	JBAjoutProfContentPane.setBounds(150,160,150,30);
    	
    	PaymentLabel.setBounds(50, 80, 100, 30);
    	PaymentTextField.setBounds(150, 80, 150, 30);
    	AjoutePaymentProf.setBounds(150,120,150,30);
    	
    	SuprimerProfButton.setBounds(150,80,150,30);
	}
		
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == AjouterProf) {
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNILabel);
			JPcontentPnae.add(CNETextField);
			JPcontentPnae.add(NomeLabel);
			JPcontentPnae.add(NomeTextField);
			JPcontentPnae.add(PrenomLabel);
			JPcontentPnae.add(PrenomTextField);
			JBAjoutProfContentPane.setBackground(getBackgroundPurpol());
			JBAjoutProfContentPane.setForeground(getBackgroundWhite());
			setLocationAndSizeAjoute();
			JPcontentPnae.add(JBAjoutProfContentPane);
			new ACtionConetentFormsAjouter(JBAjoutProfContentPane, CNETextField, NomeTextField, PrenomTextField);
		}
		if(event.getSource() == AfficheProf){
			//===============design the affiche page jtable
			System.out.println("clicked");
			new IDProfesseurImp().affiche_p(JPcontentPnae);
		}
		if(event.getSource() == PaymentProf){
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNILabel);
			JPcontentPnae.add(CNETextField);
			JPcontentPnae.add(PaymentLabel);
			JPcontentPnae.add(PaymentTextField);
			setLocationAndSizeAjoute();

			JPcontentPnae.add(AjoutePaymentProf);
			new ActionContentFormsPayement(AjoutePaymentProf,CNETextField,PaymentTextField);
			
		}
		if(event.getSource() == SupprimerProf){
			System.out.println("clicked");
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			JPcontentPnae.add(CNILabel);
			JPcontentPnae.add(CNETextField);
			JPcontentPnae.add(SuprimerProfButton);
			
			new ActionContentSuprimerFrom(SuprimerProfButton, CNETextField);
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
