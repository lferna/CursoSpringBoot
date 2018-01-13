package com.curso.alumnos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="usuario_asignatura")
public class UsuarioAsignaturaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_usuario")
	private List<Integer> idUsuario;

	@Column(name = "id_asignatura")
	private List<Integer> idAsignatura;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Integer> getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(List<Integer> idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Integer> getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(List<Integer> idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	
	
}
