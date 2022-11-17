package SinglotonConnectionnnection;

import java.sql.*;

public class Connecter {
	private static Connection con;
	static {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl ","sys as sysdba","system");
					
		}catch(ClassNotFoundException e){
			System.out.println("Problème au niveau du pilote");
		}catch(SQLException e) {
			System.out.println("Problème au niveau de base ou accès au données");
		}
	}
	public static Connection getCon() {
		return con;
	}

}
