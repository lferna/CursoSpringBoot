package com.curso.alumnos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.curso.alumnos.dao.UsuarioDao;
import com.curso.alumnos.dto.UsuarioDto;
import com.curso.alumnos.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	@Override
	public UsuarioDto findByName(String nombre) {
		// TODO Auto-generated method stub
		return null; //alumnoDao.findByName(nombre);
	}
	
	public void saveUser(UsuarioDto usuarioDto) {
		usuarioDto.setPassword(bCryptPasswordEncoder.encode(usuarioDto.getPassword()));
		this.usuarioDao.saveUsuario(usuarioDto);
	}
	
	public List<UsuarioDto> getUsuarios(Long rol_id){
		return this.usuarioDao.getUsuarios(rol_id);
	}
	
	

}
