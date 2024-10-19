package com.curso.vnc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SegurancaConfig {
	
	@Autowired
	FiltroDeSeguranca filtroDeSeguranca;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		return security.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.POST, "/auth/cadastro").permitAll()
						.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
						//Categoria
						.requestMatchers(HttpMethod.GET, "/categorias").permitAll()
						.requestMatchers(HttpMethod.POST, "/categorias").permitAll()
						//Cliente
						.requestMatchers(HttpMethod.GET, "/clientes").permitAll()
						.requestMatchers(HttpMethod.POST, "/clientes/*").permitAll()
						//Produto
						.requestMatchers(HttpMethod.GET, "/produtos").permitAll()
						.requestMatchers(HttpMethod.POST, "/produtos").permitAll()
						.requestMatchers(HttpMethod.POST, "/produtos/{categoriaId}").permitAll()
//						.requestMatchers(HttpMethod.POST, "/categorias").hasRole("ADMIN")
//						.requestMatchers(HttpMethod.GET, "/clientes").hasRole("ADMIN")
						.anyRequest().permitAll())
				.addFilterBefore(filtroDeSeguranca , UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
