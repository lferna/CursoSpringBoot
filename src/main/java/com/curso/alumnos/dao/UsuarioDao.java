package com.curso.alumnos.dao;

import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.entity.UsuarioEntity;



public interface UsuarioDao{
	
	UsuarioEntity findByNombre(String nombre);
	
	UsuarioEntity findByUsuario(String username);
	
	void saveUsuario(UsuarioDto usuarioDto);
}
