package com.curso.alumnos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.curso.alumnos.configuration.dao.GenericDao;
import com.curso.alumnos.dao.UsuarioDao;
import com.curso.alumnos.dto.RolDto;
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
	public UsuarioDto findByUsuario(String username) {
		
		Query q = entityManager.createQuery(
				"FROM UsuarioEntity e WHERE usuario = :username");
			q.setParameter("username", username);
			UsuarioEntity usuarioEntity = (UsuarioEntity)q.getSingleResult();
		UsuarioDto usuarioDto = new UsuarioDto();
		RolDto rolDto = new RolDto();
		BeanUtils.copyProperties(usuarioEntity, usuarioDto);
		BeanUtils.copyProperties(usuarioEntity.getRol(), rolDto);
		usuarioDto.setRol(rolDto);
		
		return usuarioDto;
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
	
	@Override
	@Transactional
	public void deleteUsuario(String username) {
		this.entityManager.remove(this.findByUsuario(username));		
	}	
	

	@Override
	public List<UsuarioDto> getUsuarios(Long rol_id) {
			Query q = entityManager.createQuery(
					"SELECT e FROM UsuarioEntity e, RolEntity r WHERE r.id = :rol_id and r.id = e.rol.id");
			q.setParameter("rol_id", rol_id);
			
			List<UsuarioEntity> listUsuarioEntity = q.getResultList();
			List<UsuarioDto> listUsuarioDto = new ArrayList<UsuarioDto>();
			for (UsuarioEntity usuarioEntity : listUsuarioEntity) {
				UsuarioDto usuarioDto = new UsuarioDto();
				BeanUtils.copyProperties(usuarioEntity, usuarioDto);
				listUsuarioDto.add(usuarioDto);
			}
			return listUsuarioDto;
	}

}
