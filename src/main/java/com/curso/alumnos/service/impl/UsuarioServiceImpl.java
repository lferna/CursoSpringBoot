package com.curso.alumnos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.alumnos.dao.UsuarioDao;
import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@Override
	public UsuarioDto findByName(String nombre) {
		// TODO Auto-generated method stub
		return null; //alumnoDao.findByName(nombre);
	}
	
	public void saveUser(UsuarioDto usuarioDto) {
		this.usuarioDao.saveUsuario(usuarioDto);
	}

}
