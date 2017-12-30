package com.curso.alumnos.service.impl;

import org.springframework.stereotype.Service;

import com.curso.alumnos.dao.UsuarioDao;
import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.service.UsuarioService;

@Service("alumnoService")
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioDao alumnoDao;
	@Override
	public UsuarioDto findByName(String nombre) {
		// TODO Auto-generated method stub
		return null; //alumnoDao.findByName(nombre);
	}

}
