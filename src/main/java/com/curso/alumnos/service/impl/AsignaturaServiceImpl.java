package com.curso.alumnos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.alumnos.dao.AsignaturaDao;
import com.curso.alumnos.dto.AsignaturaDto;
import com.curso.alumnos.service.AsignaturaService;

@Service("asignaturaService")
public class AsignaturaServiceImpl implements AsignaturaService{

	@Autowired
	private AsignaturaDao asignaturaDao;

	@Override
	public List<AsignaturaDto> getAsignaturas() {
		
		return asignaturaDao.getAsignaturas();
	}
		
	

}
