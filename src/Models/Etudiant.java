package Models;

public class Etudiant {
  
    private String nom_e,prenom_e;
    private int CNE,abs;
    private int payment;
    private int note;
    private String nom_c;
	public String getNom_e() {
		return nom_e;
	}
	public void setNom_e(String nom_e) {
		this.nom_e = nom_e;
	}
	public String getPrenom_e() {
		return prenom_e;
	}
	public void setPrenom_e(String prenom_e) {
		this.prenom_e = prenom_e;
	}
	public int getAbs() {
		return abs;
	}
	public void setAbs(int abs) {
		this.abs = abs;
	}
	public String getNom_c() {
		return nom_c;
	}
	public void setNom_c(String nom_c) {
		this.nom_c = nom_c;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getCNE() {
		return CNE;
	}
	public void setCNE(int cNE) {
		CNE = cNE;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
 
}
