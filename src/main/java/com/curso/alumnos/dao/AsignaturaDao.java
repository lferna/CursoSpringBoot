package com.curso.alumnos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.alumnos.entity.AsignaturaEntity;

@Repository
public interface AsignaturaDao extends CrudRepository<AsignaturaEntity,Long>{

}
