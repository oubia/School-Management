package DashBoard;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import SinglotonConnectionnnection.Connecter;

public class HomeContent {
	Connection con=Connecter.getCon();

	public void addComponentsToHome(JPanel JPcontentPnae ,JPanel JHeader) {
		JHeader.removeAll();
		JHeader.revalidate();
		JHeader.repaint();
		JPcontentPnae.removeAll();
		JPcontentPnae.revalidate();
		JPcontentPnae.repaint();
		JPcontentPnae.setBackground(getBackgroundWhite());

		JPanel class_count = new JPanel();
		String req="select count(*) from Classe ";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				int nbr=res.getInt("count(*)");
				JLabel lb = new JLabel(Integer.toString(nbr));
				JLabel nbr_class_Label = new JLabel("Nombre des Classes");
				nbr_class_Label.setForeground(getBackgroundWhite());
				lb.setForeground(getBackgroundWhite());
				class_count.add(nbr_class_Label);
				class_count.add(lb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		class_count.setBounds(150,50,200,30);
		class_count.setBackground(getBackgroundPurpol());
		
		
		JPanel prof_count = new JPanel();
		String reqprof="select count(*) from Professeur ";
		try {
			PreparedStatement ps=con.prepareStatement(reqprof);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				int nbr=res.getInt("count(*)");
				JLabel lb = new JLabel(Integer.toString(nbr));
				JLabel nbr_prof_Label = new JLabel("Nombre des Professeurs");
				nbr_prof_Label.setForeground(getBackgroundWhite());
				lb.setForeground(getBackgroundWhite());
				prof_count.add(nbr_prof_Label);
				prof_count.add(lb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		prof_count.setBounds(150,50,200,30);
		prof_count.setBackground(getBackgroundPurpol());
		
		JPanel Etudiant_count = new JPanel();
		String reqetudiant="select count(*) from Professeur ";
		try {
			PreparedStatement ps=con.prepareStatement(reqetudiant);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				int nbr=res.getInt("count(*)");
				JLabel lb = new JLabel(Integer.toString(nbr));
				JLabel nbr_etudiant_Label = new JLabel("Nombre des Etudiant");
				nbr_etudiant_Label.setForeground(getBackgroundWhite());
				lb.setForeground(getBackgroundWhite());
				Etudiant_count.add(nbr_etudiant_Label);
				Etudiant_count.add(lb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Etudiant_count.setBounds(150,50,200,30);
		Etudiant_count.setBackground(getBackgroundPurpol());
		JPcontentPnae.add(class_count);	
		JPcontentPnae.add(prof_count);	
		JPcontentPnae.add(Etudiant_count);	
	}
	private Color getBackgroundWhite() {
		return Color.white;
	}
	public Color getBackgroundPurpol() {
    	return new java.awt.Color(63, 42, 100);
    }
}
