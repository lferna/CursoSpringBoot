package com.curso.alumnos.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.curso.alumnos.entity.UsuarioEntity;


@Repository
public interface UsuarioDao extends CrudRepository<UsuarioEntity,Long>{
	
	UsuarioEntity findByNombre(String nombre);
	
	UsuarioEntity findByUsuario(String username);
}
