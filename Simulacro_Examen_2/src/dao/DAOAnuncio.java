package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import db.DB;

import modelos.Anuncio;


public class DAOAnuncio implements Serializable{
	public static final long serialVersionUID=1L;

private Connection con;//se podria private Connection con=Db.getConexion();
	
	public DAOAnuncio(){
		
		con=DB.getConexion();
		
	}
		
		public ArrayList<Anuncio> read(String contenido){
			ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
			Anuncio a=null;
			String sql="select contenido from anuncios where contenido like ?";
			
			try{
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "%"+contenido+"%");
				ResultSet rs=ps.executeQuery();//devuelve datos(ResultSet) por eso executeQuery
				
				/*if(rs.next()){
					p=new Libros(rs.getInt("isbn"),titulo,rs.getString("autor"),rs.getInt("paginas"));
				}
				rs.close();*/
				
				
				while(rs.next()){
					a=new Anuncio(rs.getInt("id"),rs.getString("contenido"));
					anuncios.add(a);
				}
				rs.close();
				
				
			}
			
			catch(SQLException sqle){
				
				sqle.printStackTrace();
				
			}
			
			return anuncios;
			
		}
		
	
	public ArrayList<Anuncio> listar(){
		ArrayList<Anuncio> lista=new ArrayList<Anuncio>();
		
		String sql="select contenido from anuncios";
		try(Connection con=DB.getConexion();
		    Statement st=con.createStatement()){
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Anuncio a=new Anuncio(rs.getInt("id"),rs.getString("contenido"));
				lista.add(a);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	}
}


