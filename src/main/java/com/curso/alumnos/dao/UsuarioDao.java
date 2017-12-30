package com.curso.alumnos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.alumnos.entity.UsuarioEntity;


@Repository("usuarioRepository")
public interface UsuarioDao extends CrudRepository<UsuarioEntity,Long>, UsuarioRepositoryCustom{
	
	UsuarioEntity findByName(String nombre);/*
	
	//@Query("select u from UsuarioEntity u where u.usuario = ?1")
	UsuarioEntity findByUsername(String username);*/
}
