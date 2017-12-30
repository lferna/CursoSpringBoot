package com.curso.alumnos.configuration.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.curso.alumnos.dao.UsuarioDao;
import com.curso.alumnos.entity.UsuarioEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 UsuarioEntity usuarioEntity = null;  //usuarioDao.findByUsername(username);
		 Set<GrantedAuthority> grantedAuthorities = new HashSet();
		 /*for (Rol role : user.getRoles()){
		 grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		 }*/
		 
		User user = new User(usuarioEntity.getUsuario(),usuarioEntity.getPassword(), grantedAuthorities);
		
		return user;
	}

}
