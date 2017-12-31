package com.curso.alumnos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.curso.alumnos.configuration.dao.GenericDao;
import com.curso.alumnos.dao.UsuarioDao;
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
	
}
