package com.curso.alumnos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private UserDetailsService userDetailsService;


	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		 .authorizeRequests()
		 .antMatchers("/resources/**").permitAll()
		 .antMatchers("/admin/**").hasAuthority("Admin")	
		 .antMatchers("/alumno/**").hasAnyAuthority("Admin","Alumno")
		 .antMatchers("/profesor/**").hasAnyAuthority("Admin","Profesor")
		 .anyRequest().authenticated()			
		 .and()
		 .formLogin()
		 .usernameParameter("username")
		 .passwordParameter("password")		 
		 .loginProcessingUrl("/j_spring_security_check") // Submit URL
		 .loginPage("/login").failureUrl("/login?error=true")
		 .defaultSuccessUrl("/home")
		 .permitAll()
		 .and()
		 .logout()
		 .permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}


}
