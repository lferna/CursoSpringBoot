package com.curso.alumnos.service;

import com.curso.alumnos.dto.UsuarioDto;

public interface UsuarioService {

	UsuarioDto findByName(String nombre);
}
