package com.StoreOnline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//anotación para habilitar la seguridad
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*http.authorizeHttpRequests((auth)-> auth.anyRequest().authenticated())
			.formLogin(form-> form.loginPage("/login")
			.permitAll().defaultSuccessUrl("/medicamento/lista"));*/
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((auth)->{
			auth.antMatchers("/index").hasRole("admin");
			
			auth.anyRequest().authenticated();})
		.formLogin(form-> form.loginPage("/login")
		.permitAll().defaultSuccessUrl("/index"));
		
		return http.build();
	}
	
	
	
	/*
	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {
		//crear objeto de la InMemoryUserDetailsManager
		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("luis").password(encoder.encode("123")).roles("USER").build());
		manager.createUser(User.withUsername("carlos").password(encoder.encode("456")).roles("ADMIN").build());
		
		return manager;
	}
	
	*/
	
	
}
