package modelos;

import java.util.Date;

import utils.DateUtils;

public class Equipo {

	public enum TipoEquipo{
		ORDENADOR,IMPRESORA,MONITOR
	}
	
	private int id;
	private TipoEquipo tipo;
	private String ubicacion;
	private String modelo;
	private Date fechaInstalacion;
	
	public Equipo(){
		
	}
	
	public Equipo(int id,TipoEquipo tipo,String ubicacion,String modelo,Date fechaInstalacion){
		this.id=id;
		this.tipo=tipo;
		this.ubicacion=ubicacion;
		this.modelo=modelo;
		this.fechaInstalacion=fechaInstalacion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoEquipo getTipo() {
		return tipo;
	}
	
	public String getStringTipo(){
		return tipo.toString();
	}
	
	public void setTipo(TipoEquipo tipo) {
		this.tipo = tipo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}
	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
	
	public String getStringFechaInstalacion(){
		return DateUtils.formatearFecha(fechaInstalacion);
	}
	
	
	
	
}
