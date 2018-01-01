package com.curso.alumnos.configuration;

import javax.sql.DataSource;

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
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;


	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		BCryptPasswordEncoder encoder = passwordEncoder();
		http
		 .authorizeRequests()
		 .antMatchers("/resources/**").permitAll()
		 .anyRequest().authenticated()
		 .antMatchers("/admin/**").hasAnyRole("Admin")	
		 .antMatchers("/alumno/**").hasAnyRole("Alumno")
		 .antMatchers("/profesor/**").hasAnyRole("Profesor")
		 .and()
		 .formLogin()
		 .usernameParameter("email")
		 .passwordParameter("password")		 
		 .loginProcessingUrl("/j_spring_security_check") // Submit URL
		 .loginPage("/login").failureUrl("/login?error=true")
		 .defaultSuccessUrl("/admin/home")
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

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
