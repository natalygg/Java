package modelos;

import java.io.Serializable;

public class Anuncio implements Serializable{
	public static final long serialVersion=1L;
	

	private int id;
	private String contenido;
	
public Anuncio(){
	
}

public Anuncio(int id, String contenido){
	
	this.id=id;
	this.contenido=contenido;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getContenido() {
	return contenido;
}

public void setContenido(String contenido) {
	this.contenido = contenido;
}


}
