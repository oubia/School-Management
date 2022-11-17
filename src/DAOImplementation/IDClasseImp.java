package DAOImplementation;
import DAOInterface.*;
import SinglotonConnectionnnection.Connecter;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;

import javax.swing.JPanel;
import javax.swing.JTable;

public class IDClasseImp implements IClasse{
	Connection con=Connecter.getCon();
	

	@Override
	public void affiche_c(JPanel JPcontentPnae) {
		int i=1;
		try {
			String req="select * from Classe ";
			PreparedStatement ps=con.prepareStatement(req);
			ResultSet res=ps.executeQuery();
			JTable tab_c = new JTable();
			tab_c.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {"Classes"},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null},
		                {null}
		            },
		            new String [] {
		                "Classes"
		            }
		        ));
			while(res.next()) {
				String classes=res.getString("nom_c");
				  tab_c.setValueAt(classes, i, 0);
	               i=i+1;
			}
			tab_c.setGridColor(new java.awt.Color(53, 33, 89));
			tab_c.setSelectionBackground(new Color(13,190,255));
			tab_c.setBounds(30,50,450,300);   
			JPcontentPnae.add(tab_c);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public JTable aff_etud_c(String n_c) {
		String req="select nom_e,prenom_e,nom_c from etudiant where UPPER(nom_c)=UPPER('"+n_c+"') ";
		int i = 1;
		JTable tab_e_c = new JTable();

		try {
			PreparedStatement ps=con.prepareStatement(req);
			ResultSet res=ps.executeQuery();
			tab_e_c.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {"Nom", "Prénom"},
		                {null, null},
		                {null, null},
		                {null, null},
		                {null, null},
		                {null, null},
		                {null, null},
		                {null, null},
		                {null, null},
		                {null, null}
		            },
		            new String [] {
		                "Nom", "Prénom"
		            }
		        ));
			System.out.println("Voici la liste des etudiants de 33333class:");
            while(res.next()){  
                String nom_e=res.getString("nom_e");
                String prenom_e=res.getString("prenom_e");
                System.out.println(nom_e+"    "+prenom_e);
                tab_e_c.setValueAt(nom_e, i, 0);
                tab_e_c.setValueAt(prenom_e, i, 1);
                
               i=i+1;
            }
            tab_e_c.setGridColor(new java.awt.Color(53, 33, 89));
            tab_e_c.setSelectionBackground(new Color(13,190,255));
			tab_e_c.setBounds(30,150,450,300); 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tab_e_c;
		
	}

	@Override
	public void ajoute_c(String nom_c) {
		String req="INSERT INTO Classe VALUES ('"+nom_c+"')";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
