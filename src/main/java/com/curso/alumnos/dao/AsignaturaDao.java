package com.curso.alumnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.alumnos.entity.AsignaturaEntity;

public interface AsignaturaDao extends JpaRepository<AsignaturaEntity,Long>{

}
