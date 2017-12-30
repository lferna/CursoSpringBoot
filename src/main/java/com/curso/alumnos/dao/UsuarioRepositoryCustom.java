package com.curso.alumnos.dao;

import com.curso.alumnos.entity.UsuarioEntity;

public interface UsuarioRepositoryCustom {
	
	
	UsuarioEntity findByName(String nombre);
	
	/*UsuarioEntity findByUsername(String usuario);*/
}
