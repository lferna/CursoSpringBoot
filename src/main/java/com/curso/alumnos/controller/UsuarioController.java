package com.curso.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.service.impl.RolServiceImpl;
import com.curso.alumnos.service.impl.UsuarioServiceImpl;

@Controller
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
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/menu", method = RequestMethod.GET,  params="action=viewNewUser")
	public ModelAndView viewNewUser(){
		UsuarioDto usuarioDto = new UsuarioDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNewUser");
		modelAndView.addObject("usuarioDto", usuarioDto);
		modelAndView.addObject("listRoles",rolService.getRoles());
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/admin/menu", method = RequestMethod.GET,  params="action=viewNewSubject")
	public ModelAndView viewNewSubject(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNewSubject");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/menu", method = RequestMethod.GET,  params="action=viewListStudent")
	public ModelAndView viewListStudent(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListStudent");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/menu", method = RequestMethod.GET,  params="action=viewListTeacher")
	public ModelAndView viewListTeacher(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListTeacher");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/menu", method = RequestMethod.GET,  params="action=viewListSubject")
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
	
	
}
