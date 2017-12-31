package com.curso.alumnos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNewUser");
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
	
	
}
