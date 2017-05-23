package com.equipos.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOEquipo;
import dao.DAOEquipoImpl;
import dao.DAOUser;
import modelos.Equipo;
import modelos.User;
import utils.DateUtils;

@Controller
public class EquiposController {

	
	@Autowired
	DAOEquipo daoe;
	
	@Autowired
	DAOUser daou;
	
	
    @RequestMapping(value={"/index","/"})
    public ModelAndView index(HttpSession sesion){
    	ModelAndView mv = new ModelAndView("index");
    	mv.addObject("tituloPagina","titulo.index");
    	
    	return mv;
    }
    
	@RequestMapping("/listadoEquipos")
	public ModelAndView listadoEquipos(HttpSession sesion) {

		ModelAndView mv = null;

		mv = new ModelAndView("listadoequipos");

			
		List<Equipo> lista = daoe.listar();
		mv.addObject("tituloPagina","titulo.listado_equipos");
		mv.addObject("lista", lista);
		mv.addObject("tipos",Equipo.TipoEquipo.values());
		mv.addObject("formatoFecha",DateUtils.getFormatoFechaVista());

		return mv;
	}

	@RequestMapping("/altaEquipo")
	public ModelAndView altaEquipo(HttpSession sesion, HttpServletResponse response,
			@RequestParam(value = "tipo") Equipo.TipoEquipo tipo,
			@RequestParam(value = "ubicacion") String ubicacion,
			@RequestParam(value = "modelo") String modelo,
			@RequestParam(value = "fechaInstalacion") String fechaInstalacion) {

		Date d = DateUtils.parse(fechaInstalacion);
		Equipo e = new Equipo(-1, tipo, ubicacion, modelo, d);
		
		daoe.create(e);
		
		return listadoEquipos(sesion);
	}

	@RequestMapping("/borrarEquipo")
	public ModelAndView borrarEquipo(
			HttpSession sesion, 
			@RequestParam(value = "id") int id) {

		daoe.delete(id);
		return listadoEquipos(sesion);
		
	}
	
	@RequestMapping("/editarEquipo")
	public ModelAndView editarEquipo(
			HttpSession sesion, 
			@RequestParam(value = "id") int id) {

		Equipo e=daoe.read(id);
		
		ModelAndView mv = null;

		mv = new ModelAndView("editarequipo");
		mv.addObject("tituloPagina","titulo.edicion_equipo");
		mv.addObject("equipo",e);
		mv.addObject("tipos",Equipo.TipoEquipo.values());
		mv.addObject("fechaInstalacion",DateUtils.formatearFecha(e.getFechaInstalacion()));
		mv.addObject("formatoFecha",DateUtils.getFormatoFechaVista());
		return mv;
	}
	
	@RequestMapping("/modificarEquipo")
	public ModelAndView modificarEquipo(
			HttpSession sesion, 
			HttpServletResponse response,
			@RequestParam(value = "id") int id,
			@RequestParam(value = "tipo") Equipo.TipoEquipo tipo, 
			@RequestParam(value = "ubicacion") String ubicacion,
			@RequestParam(value = "modelo") String modelo,
			@RequestParam(value = "fechaInstalacion") String fechaInstalacion){
		SimpleDateFormat parser = new SimpleDateFormat(DateUtils.getFormatoFecha());
		try {
			Date d = parser.parse(fechaInstalacion);
			Equipo e=new Equipo(id,tipo,ubicacion,modelo,d);
			daoe.update(e);

		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		
		return listadoEquipos(sesion);
	}
	
	@RequestMapping("/listadoUsuarios")
	public ModelAndView listadoUsuarios(HttpSession sesion) {

		ModelAndView mv = null;

			mv = new ModelAndView("listadousuarios");

			
		List<User> lista = daou.listar();
		mv.addObject("tituloPagina","titulo.listado_usuarios");
		mv.addObject("lista", lista);
		mv.addObject("authorities",User.Authority.values());
		

		return mv;
	}

	@RequestMapping("/altaUsuario")
	public ModelAndView altaUsuario(HttpSession sesion, HttpServletResponse response,
			@RequestParam(value = "username") String username, 
			@RequestParam(value = "authority") User.Authority authority,
			@RequestParam(value = "password") String password) {

			User e = new User(username,authority);
			daou.create(e,password);
			
		return listadoUsuarios(sesion);
		
	}

	@RequestMapping("/borrarUsuario")
	public ModelAndView borrarUsuario(
			HttpSession sesion, 
			@RequestParam(value = "username") String username) {

		daou.delete(username);
		return listadoUsuarios(sesion);
		
	}
	
	@RequestMapping("/editarUsuario")
	public ModelAndView editarUsuario(
			HttpSession sesion, 
			@RequestParam(value = "username") String username) {

		User u=daou.read(username);
		
		ModelAndView mv = null;

		mv = new ModelAndView("editarusuario");
		mv.addObject("tituloPagina","titulo.edicion_usuario");
		mv.addObject("usuario",u);
		mv.addObject("authorities",User.Authority.values());
		return mv;
	}
	
	@RequestMapping("/modificarUsuario")
	public ModelAndView modificarUsuario(
			HttpSession sesion, 
			HttpServletResponse response,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "authority") User.Authority authority, 
			@RequestParam(value = "password") String password){
		
			User u=new User(username,authority);
			daou.update(u);

			if(!password.equals("")){
				daou.recordPassword(username,password);
			}
		
		
			return listadoUsuarios(sesion);
	}

}
