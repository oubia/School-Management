package DAOImplementation;
import DAOInterface.*;
import SinglotonConnectionnnection.Connecter;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IDProfesseurImp implements IProfesseur {
	Connection con=Connecter.getCon();
	
	@Override
	public void ajoute_p(int CNI, String nom_p, String prenom_p) {
		try{
            float x= (float) (Math.random()*10000);
            float y= (float) (Math.random()*10000);
            int log_pr=(int)x; 
            int passwrd_pr=(int)y;
            String req="INSERT INTO Professeur ( CNI,nom_p,prenom_p,log_p,passwrd_p) VALUES ("+CNI+",'"+nom_p+"','"+prenom_p+"',"+log_pr+","+passwrd_pr+")";
            PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();
        }
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supp_p(int CNI) {
		String req="DELETE FROM Professeur where CNI="+CNI;
		try{
			PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();

        }catch(SQLException e){
        	e.printStackTrace();
        }
		
		
	}

	@Override
	public void affiche_p(JPanel JPcontentPnae) {
		try{
			JPcontentPnae.removeAll();
			JPcontentPnae.revalidate();
			JPcontentPnae.repaint();
			JPcontentPnae.setLayout(null);
			JPcontentPnae.setBackground(Color.white);
			JPcontentPnae.setPreferredSize(new Dimension(500,430));
			 int i=1;
				JTable tab_prof = new JTable();
				 tab_prof.setModel(new javax.swing.table.DefaultTableModel(
				            new Object [][] {
				                {"CNI", "Nom", "Prénom", "Salaire", "Login", "Mode de Passs"},
				                {null, null, null, null, null, null},
				                {null, null, null, null, null, null},
				                {null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},{null, null, null, null, null, null},
				                {null, null, null, null, null, null},
				                {null, null, null, null, null, null}
				            },
				            new String [] {
				            		"CNI", "Nom", "Prénom", "Salaire", "Login", "Mode de Passs"
				            }
				        ));
				        tab_prof.setGridColor(new java.awt.Color(53, 33, 89));
				       tab_prof.setSelectionBackground(new Color(13,190,255));
				tab_prof.setBounds(30,50,450,300);    
			    JScrollPane sp=new JScrollPane();    
			    sp.setViewportView(tab_prof);
				JPcontentPnae.add(tab_prof);
            String req="select * from Professeur ";
            PreparedStatement ps=con.prepareStatement(req);
            ResultSet res=ps.executeQuery();
            
            System.out.println("Voici la liste  des professeurs:");
            while(res.next()){
                int CNI=res.getInt("" + "CNI");
                String nom_p=res.getString("nom_p");
                String prenom_p=res.getString("prenom_p");
                int salaire=res.getInt("salaire");
                int log_p = res.getInt("log_p");
                int passwrd_p = res.getInt("passwrd_p");
                tab_prof.setValueAt(CNI, i, 0);
                tab_prof.setValueAt(nom_p, i, 1);
                tab_prof.setValueAt(prenom_p, i, 2);
                tab_prof.setValueAt(salaire, i, 3);
                tab_prof.setValueAt(log_p, i, 4);
                tab_prof.setValueAt(passwrd_p, i, 5);
                i=i+1;
                
                System.out.println(CNI+"\t"+nom_p+"\t"+prenom_p+"\t"+salaire+"\t"+log_p+"\t"+passwrd_p);
            }
            JPcontentPnae.add(tab_prof);
        }catch(SQLException e){
            System.out.println("Erreur !!:"+e);
        }
		
	}

	@Override
	public void ajoute_salaire(int CNI, int s) {
		try{
            String req="UPDATE Professeur SET salaire="+s+" WHERE CNI="+CNI+"";
            PreparedStatement ps=con.prepareStatement(req);
			ps.executeUpdate();
        }catch(SQLException e){
        	e.printStackTrace();
        }
		
	}

}
