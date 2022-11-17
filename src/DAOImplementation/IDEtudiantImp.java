package DAOImplementation;
import DAOInterface.*;

import SinglotonConnectionnnection.Connecter;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IDEtudiantImp implements IEtudiant{
	Connection con=Connecter.getCon();
	@Override
	public void ajoute_e(String nom_e, String prenom_e, int CNE, String nom_c) {
		String req="INSERT INTO Etudiant (nom_e, prenom_e,CNE,nom_c)VALUES ('"+nom_e+"','"+prenom_e+"',"+CNE+",'"+nom_c+"')";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supp_e(int CNE) {
		String req="DELETE FROM Etudiant where CNE="+CNE;
		try{
			PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();

        }catch(SQLException e){
        	e.printStackTrace();
        }
		
	}

	@Override
	public void affiche_e(JPanel JPcontentPnae) {
		try{
			JPcontentPnae.removeAll();
 			JPcontentPnae.revalidate();
 			JPcontentPnae.repaint();
 			JPcontentPnae.setLayout(null);
 			JPcontentPnae.setBackground(Color.white);
 			JPcontentPnae.setPreferredSize(new Dimension(500,430));
            String req="select * from Etudiant ";
            PreparedStatement ps=con.prepareStatement(req);
            ResultSet res=ps.executeQuery();
            int i=1;
			JTable tab_etud = new JTable();
			 tab_etud.setModel(new javax.swing.table.DefaultTableModel(
			            new Object [][] {
			                {"CNE", "Nom", "Prénom", "Classe", "Payment", "Note", "Absence"},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null},
			                {null, null, null, null, null, null, null}
			            },
			            new String [] {
			                "CNE", "Nom", "Prénom", "Classe", "Payment", "Note", "Absence"
			            }
			        ));
			        tab_etud.setGridColor(new java.awt.Color(53, 33, 89));
			       tab_etud.setSelectionBackground(new Color(13,190,255));
			tab_etud.setBounds(30,50,450,300);    
		    JScrollPane sp=new JScrollPane();    
		    sp.setViewportView(tab_etud);
			JPcontentPnae.add(tab_etud);
            System.out.println("Voici la liste  des etudiants:");
            while(res.next()){
                int CNE=res.getInt("CNE");
                String nom_e=res.getString("nom_e");
                String prenom_e=res.getString("prenom_e");
                String nom_c=res.getString("nom_c");
                int payment=res.getInt("payment");
                float note=res.getFloat("note");
                int abs=res.getInt("abs");
                System.out.println(CNE+"\t"+nom_e+"\t"+prenom_e+"\t"+nom_c+"\t"+payment+"\t"+note+"\t"+abs);
                tab_etud.setValueAt(CNE, i, 0);
                tab_etud.setValueAt(nom_e, i, 1);
                tab_etud.setValueAt(prenom_e, i, 2);
                tab_etud.setValueAt(nom_c, i, 3);
                tab_etud.setValueAt(payment, i, 4);
                tab_etud.setValueAt(note, i, 5);
                tab_etud.setValueAt(abs, i, 6);
                i=i+1;

    			
            }
        }catch(SQLException e){
            System.out.println("Erreur !!:"+e);
        }
		
	}

	@Override
	public void ajoute_payement(int CNE, int p) {
		String req="UPDATE Etudiant SET payment="+p+" WHERE CNE="+CNE+"";
		try{
			PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();

        }catch(SQLException e){
        	e.printStackTrace();
        }
		
	}

	@Override
	public void ajoute_abs(int CNE, int ab) {
		String req="UPDATE Etudiant SET ABS=(abs+"+ab+") WHERE CNE="+CNE+"";
		try{
			PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();

        }catch(SQLException e){
        	e.printStackTrace();
        }
		
	}

	@Override
	public void ajoute_note(int CNE, float note) {
		String req="UPDATE Etudiant SET note="+note+" WHERE CNE="+CNE+"";
		try{
			PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();

        }catch(SQLException e){
        	e.printStackTrace();
        }
		
	}

}
