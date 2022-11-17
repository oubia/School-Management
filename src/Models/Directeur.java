
package Models;
import java.sql.*;

public class Directeur {
     Connection con;
    Statement stm;
    ResultSet rst;
    private  String nom_d; 
    private int log_d=1111;
    private int passwrd_d=1111;
	public String getNom_d() {
		return nom_d;
	}
	public void setNom_d(String nom_d) {
		this.nom_d = nom_d;
	}
	public int getLog_d() {
		return log_d;
	}
	public void setLog_d(int log_d) {
		this.log_d = log_d;
	}
	public int getPasswrd_d() {
		return passwrd_d;
	}
	public void setPasswrd_d(int passwrd_d) {
		this.passwrd_d = passwrd_d;
	}
}
