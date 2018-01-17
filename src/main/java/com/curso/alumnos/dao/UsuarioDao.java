package com.curso.alumnos.dao;

import java.util.List;

import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.entity.UsuarioEntity;



public interface UsuarioDao{
	
	UsuarioEntity findByNombre(String nombre);
	
	UsuarioDto findByUsuario(String username);
	
	void saveUsuario(UsuarioDto usuarioDto);
	
	List<UsuarioDto> getUsuarios(Long rol_id);
	
	void deleteUsuario(String username);
}
