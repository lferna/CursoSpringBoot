package com.curso.alumnos.dto;

import java.util.List;

public class UsuarioDto {

	private String nombre;
	
	private String password;
	
	private String usuario;
	
	private String apellido1;
	
	private String apellido2;
	
	private String email;
	
	private RolDto rol;
	
	private List<AsignaturaDto> asignatura;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RolDto getRol() {
		return rol;
	}

	public void setRol(RolDto rol) {
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AsignaturaDto> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(List<AsignaturaDto> asignatura) {
		this.asignatura = asignatura;
	}
	

}
