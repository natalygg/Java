package dao;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import modelos.Usuario;

public class DAOUsuarios implements Serializable{
	
	public static final long serialVersionUID=1L;
	
private Connection con;//se podria private Connection con=Db.getConexion();
	
	public DAOUsuarios(){
		
		con=DB.getConexion();
		
	}
	
		
	public ResultadoCRUD create(Usuario u){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="insert into usuarios (nombre,password,dni) values (?,?,?)";
		try(Connection con=DB.getConexion();
		    PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,u.getNombre());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getDni());
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
	
	public ArrayList<Usuario> listar(){
		ArrayList<Usuario> lista=new ArrayList<Usuario>();
		
		String sql="select * from usuarios";
		try(Connection con=DB.getConexion();
		    Statement st=con.createStatement()){
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Usuario a=new Usuario(
						rs.getString("nombre"),
						rs.getString("password"),
						rs.getString("dni"));
				lista.add(a);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	}
	
	public boolean borrar(String dni){
		boolean r=false;
		
		String sql="delete * from usuarios where dni=?";
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,dni);
			ps.executeUpdate();
			r=true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return r;
	}
}



	

