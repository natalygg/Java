package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {//hacer lo que sea con la BBDD

	private static Connection con;
	
	public static void init(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","");
		}
	catch(ClassNotFoundException cnfe){
		System.out.println("No se puede conectar a la BBDD");
	}
		catch(SQLException sqle){
			System.out.println("BBDD inexistente");
		}
	}
	
	public static Connection getConexion(){
		return con;
	}
}
