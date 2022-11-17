package DAOInterface;

import javax.swing.JPanel;

public interface IEtudiant {
	public void ajoute_e(String  nom_e,String prenom_e,int CNE,String nom_c);
	public void supp_e(int CNE);
	public void ajoute_payement(int CNE,int p);
	public void ajoute_abs(int CNE,int ab);
	void affiche_e(JPanel JPcontentPnae);
	void ajoute_note(int CNE, float note);
	
}
