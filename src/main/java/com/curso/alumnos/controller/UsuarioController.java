package com.curso.alumnos.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.service.impl.RolServiceImpl;
import com.curso.alumnos.service.impl.UsuarioServiceImpl;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Autowired
	private RolServiceImpl rolService;
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value="/alumno/viewNewUser", method = RequestMethod.GET)
	public ModelAndView viewNewUser() throws SQLException{
		UsuarioDto usuarioDto = new UsuarioDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNewUser");
		modelAndView.addObject("usuarioDto", usuarioDto);
		modelAndView.addObject("listRoles",rolService.getRoles());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/profesor/viewNewSubject", method = RequestMethod.GET)
	public ModelAndView viewNewSubject(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNewSubject");
		return modelAndView;
	}
	
	@ExceptionHandler(value = SQLException.class)
	    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	        ModelAndView m = new ModelAndView("admin/viewListUser");
	        m.addObject("exception", e.toString());
	        m.addObject("url", req.getRequestURL());
	        return m;
	 }
	
	@RequestMapping(value="/admin/viewListAdmin", method = RequestMethod.GET)
	public ModelAndView viewListAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListUser");
		//obtenemos los usuarios que sean del tipo estudiante
		modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		return modelAndView;
	}
	
	@RequestMapping(value="/alumno/viewListStudent", method = RequestMethod.GET)
	public ModelAndView viewListStudent(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListUser");
		//obtenemos los usuarios que sean del tipo estudiante
		modelAndView.addObject("listUsers",usuarioService.getUsuarios(2L));
		return modelAndView;
	}
	
	@RequestMapping(value="/profesor/viewListTeacher", method = RequestMethod.GET)
	public ModelAndView viewListTeacher(){
		ModelAndView modelAndView = new ModelAndView();
		//obtenemos los usuarios que sean del tipo profesor
		modelAndView.addObject("listUsers",usuarioService.getUsuarios(3L));
		modelAndView.setViewName("admin/viewListUser");
		return modelAndView;
	}
	
	@RequestMapping(value="/profesor/viewListSubject", method = RequestMethod.GET)
	public ModelAndView viewListSubject(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListSubject");
		return modelAndView;
	}
	

	@RequestMapping(value="/admin/createNewUser", method = RequestMethod.POST)
	public ModelAndView saveNewUser(@ModelAttribute UsuarioDto usuarioDto,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		usuarioService.saveUser(usuarioDto);
		modelAndView.setViewName("admin/viewNewUser");
		return modelAndView;
	}
	

	@RequestMapping(value="/alumno/deleteUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(@RequestParam("idChecked") List<String> idUsuario){
		ModelAndView modelAndView = new ModelAndView();
		if (idUsuario!=null && idUsuario.size()>0) {
			for (String username:idUsuario)
				usuarioService.deleteUsuario(username);
			}
		modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		modelAndView.setViewName("admin/viewListUser");
		return modelAndView;
	}
	
	
	
}
