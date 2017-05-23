package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import datos.Db;

import modelo.Libro;

public class DAOLibro {

	private Connection con=Db.getConexion();
	
public boolean create(Libro p) {
		
		//Connection con=Db.getConexion();
		String sql="Insert into libro(isbn,titulo,autor,paginas) values(?,?,?,?)";
		
		try{
		 PreparedStatement ps=con.prepareStatement(sql);
		 ps.setInt(1,p.getIsbn());
		 ps.setString(2, p.getTitulo());
		 ps.setString(3, p.getAutor());
		 ps.setInt(4, p.getPaginas());
		 ps.executeUpdate();
		 ps.close();
		 return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	
	public Libro read(String titulo){
		Libro p=null;
		
		
		String sql="select * from libro where titulo like ?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "%"+titulo+"%");
			ResultSet rs=ps.executeQuery();//devolver datos executeQuery
			if(rs.next()){//rs.next recorre las filas
				p=new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("paginas"));
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return p;
	}
	
	public boolean update(Libro p){
		String sql="update libro set"
				+" titulo=?,"
				+" autor=?"
				+" paginas=?"//un espacio al principio
				+" where isbn=?";//un espacio al principio
		try{
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1,p.getTitulo());
			 ps.setString(2, p.getAutor());
			 ps.setInt(3, p.getPaginas());
			 ps.setInt(4, p.getIsbn());
			 ps.executeUpdate();
			 return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Libro l){
		
		String sql="delete from libro where isbn=?";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,l.getIsbn());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException sqle){
				sqle.printStackTrace();
				return false;
			}
			
		}
	
	
}
		






