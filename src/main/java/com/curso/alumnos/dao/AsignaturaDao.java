package com.curso.alumnos.dao;

import java.util.List;

import com.curso.alumnos.dto.AsignaturaDto;



public interface AsignaturaDao{
	
	List<AsignaturaDto> getAsignaturas();
}
