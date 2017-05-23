package modelos;

import java.io.Serializable;

public class Diario implements Serializable{
	public static final long SerialVersionUID=1L;
	
	private String usuario;
	private String password;
	private int id;
	private String nombre_usuario;
	private int fecha;
	private String texto;
	
	
	
	public Diario(String usuario,String password,int id, String nombre_usuario,int fecha,String texto){
		this.usuario=usuario;
		this.password=password;
		this.id=id;
		this.nombre_usuario=nombre_usuario;
		this.fecha=fecha;
		this.texto=texto;
		
}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre_usuario() {
		return nombre_usuario;
	}



	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}



	public int getFecha() {
		return fecha;
	}



	public void setFecha(int fecha) {
		this.fecha = fecha;
	}



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}
	


}
