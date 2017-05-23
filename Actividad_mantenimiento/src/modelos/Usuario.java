package modelos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="usuario")
@SessionScoped
public class Usuario {

	private String nombre;
	private String password;
	private String dni;
	
	
	public Usuario(String nombre, String password, String dni) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
