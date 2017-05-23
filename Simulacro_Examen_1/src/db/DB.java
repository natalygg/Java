package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {

	public static Connection getConexion(){
		Connection con=null;
		try{
			Context contextoInicial=new InitialContext();
			Context envContext  = (Context)contextoInicial.lookup("java:/comp/env");
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/simulacro_examen1");
			con=dataSource.getConnection();
		}
		catch(NamingException ne){
			ne.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return con;
	}
}
