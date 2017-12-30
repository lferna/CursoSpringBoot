package com.curso.alumnos.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="asignatura")
public class AsignaturaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "creditos")
	private Double creditos;
	
/*	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="usuario")
	@JoinColumn(name="usuario_id")
	private Collection<UsuarioEntity> usuario;
*/	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	/*public Collection<UsuarioEntity> getUsuario() {
		return usuario;
	}

	public void setUsuario(Collection<UsuarioEntity> usuario) {
		this.usuario = usuario;
	}
*/
	
	
	
}
