package com.curso.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.curso.alumnos.service.impl.AsignaturaServiceImpl;

@RestController
public class AsignaturaController {
	
	@Autowired
	private AsignaturaServiceImpl asignaturaService;

	@RequestMapping(value="/viewListSubject", method = RequestMethod.GET)
	public ModelAndView viewListSubject(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListSubject");
		modelAndView.addObject("listSubjects",asignaturaService.getAsignaturas());
		return modelAndView;
	}

	
}
