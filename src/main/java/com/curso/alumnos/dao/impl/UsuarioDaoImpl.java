package com.curso.alumnos.dao.impl;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.curso.alumnos.configuration.dao.GenericDao;
import com.curso.alumnos.dao.UsuarioDao;
import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.entity.RolEntity;
import com.curso.alumnos.entity.UsuarioEntity;

@Repository
public class UsuarioDaoImpl extends GenericDao implements UsuarioDao {


	@Override
	public UsuarioEntity findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioEntity findByUsuario(String username) {
		
		Query q = entityManager.createQuery(
				"FROM UsuarioEntity e WHERE usuario >= :username");
			q.setParameter("username", username);
			UsuarioEntity usuarioEntity = (UsuarioEntity)q.getSingleResult();

		return usuarioEntity;
	}

	@Override
	@Transactional
	public void saveUsuario(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		RolEntity rolEntity = new RolEntity();		
		BeanUtils.copyProperties(usuarioDto.getRol(),rolEntity);
		BeanUtils.copyProperties(usuarioDto, usuarioEntity);	
		usuarioEntity.setRol(rolEntity);
		this.entityManager.persist(usuarioEntity);
		
	}
	

}
