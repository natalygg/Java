package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import modelos.Diario;

public class DAOUsuario {

	public ResultadoCRUD create(Diario u,String password){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="select into usuarios (nombre,password,) values (?,?)";
		try(Connection con=DB.getConexion();
		    PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,u.getNombre());
			ps.setString(2, password);
			int n=ps.executeUpdate();
			if(n>0){
				r=ResultadoCRUD.OK;
			}
			else{
				r=ResultadoCRUD.YA_EXISTE;
			}
			
		}
		catch(SQLException sqle){
			System.out.println("Fallo en la conexion a la BD");
		}
		
		return r;
	}
}
