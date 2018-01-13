package com.curso.alumnos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.curso.alumnos.configuration.dao.GenericDao;
import com.curso.alumnos.dao.AsignaturaDao;
import com.curso.alumnos.dto.AsignaturaDto;
import com.curso.alumnos.entity.AsignaturaEntity;

@Repository
public class AsignaturaDaoImpl extends GenericDao implements AsignaturaDao {

	@Override
	public List<AsignaturaDto> getAsignaturas() {
		Query q = entityManager.createQuery(
				"FROM AsignaturaEntity e");
		List<AsignaturaEntity> listAsignaturaEntity = q.getResultList();
		List<AsignaturaDto> listAsignaturaDto = new ArrayList<AsignaturaDto>();
		
		for (int i = 0; i < listAsignaturaEntity.size(); i++) {
			AsignaturaEntity asignaturaEntity  = listAsignaturaEntity.get(i);
			AsignaturaDto asignaturaDto = new AsignaturaDto();
			BeanUtils.copyProperties(asignaturaEntity, asignaturaDto );
			listAsignaturaDto.add(asignaturaDto);
		}
		 
		return listAsignaturaDto;
	}


}
