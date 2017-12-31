package com.curso.alumnos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.alumnos.dao.RolDao;
import com.curso.alumnos.dto.RolDto;
import com.curso.alumnos.service.RolService;

@Service("rolService")
public class RolServiceImpl implements RolService{

	@Autowired
	private RolDao rolDao;

	@Override
	public List<RolDto> getRoles() {
		
		return rolDao.getRoles();
	}
		
	

}
