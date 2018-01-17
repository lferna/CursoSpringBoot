package com.curso.alumnos.configuration.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.curso.alumnos.dao.UsuarioDao;
import com.curso.alumnos.dto.UsuarioDto;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 UsuarioDto usuarioDto = usuarioDao.findByUsuario(username);
		 Set<GrantedAuthority> grantedAuthorities = new HashSet();
		 grantedAuthorities.add(new SimpleGrantedAuthority(usuarioDto.getRol().getNombre()));
		 
		User user = new User(usuarioDto.getUsuario(),usuarioDto.getPassword(), grantedAuthorities);
		return user;
	}

}
