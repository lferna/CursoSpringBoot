package com.curso.alumnos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.curso.alumnos.configuration.dao.GenericDao;
import com.curso.alumnos.dao.RolDao;
import com.curso.alumnos.dto.RolDto;
import com.curso.alumnos.entity.RolEntity;

@Repository
public class RolDaoImpl extends GenericDao implements RolDao {

	@Override
	public List<RolDto> getRoles() {
		Query q = entityManager.createQuery(
				"FROM RolEntity e");
		List<RolEntity> listRolEntity = q.getResultList();
		List<RolDto> listRolDto = new ArrayList<RolDto>();
		
		for (int i = 0; i < listRolEntity.size(); i++) {
			RolEntity rolEntity  = listRolEntity.get(i);
			RolDto rolDto = new RolDto();
			BeanUtils.copyProperties(rolEntity, rolDto );
			listRolDto.add(rolDto);
		}
		 
		return listRolDto;
	}


}
