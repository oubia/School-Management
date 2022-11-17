
package Models;

public class Professeur {
   
    private int CNI;
    private String nom_p,prenom_p;
    private int salaire;
    private int  log_p;
    private int passwrd_p;
	public int getCNI() {
		return CNI;
	}
	public void setCNI(int cNI) {
		CNI = cNI;
	}
	public String getNom_p() {
		return nom_p;
	}
	public void setNom_p(String nom_p) {
		this.nom_p = nom_p;
	}
	public String getPrenom_p() {
		return prenom_p;
	}
	public void setPrenom_p(String prenom_p) {
		this.prenom_p = prenom_p;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	public int getLog_p() {
		return log_p;
	}
	public void setLog_p(int log_p) {
		this.log_p = log_p;
	}
	public int getPasswrd_p() {
		return passwrd_p;
	}
	public void setPasswrd_p(int passwrd_p) {
		this.passwrd_p = passwrd_p;
	}

 
}
