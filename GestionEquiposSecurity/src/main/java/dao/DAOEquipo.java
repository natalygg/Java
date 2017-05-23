package dao;

import java.util.List;

import javax.sql.DataSource;

import modelos.Equipo;

public interface DAOEquipo {

	public boolean create(Equipo e);
	public Equipo read(int id);
	public boolean update(Equipo e);
	public List<Equipo> listar();
	public boolean delete(int id);
	
}
