package DAOInterface;

import javax.swing.JPanel;

public interface IProfesseur {
	public void ajoute_p(int CNI,String nom_p,String prenom_p);
	public void supp_p(int CNI);
	public void ajoute_salaire(int CNI,int s);
	void affiche_p(JPanel JPcontentPnae);
	

}
