package com.curso.vnc.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.curso.vnc.repositories.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FiltroDeSeguranca extends OncePerRequestFilter {

	@Autowired
	TokenConfig tokenConfig;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var token = recuperarToken(request);

		if (token != null) {
			var login = tokenConfig.validarToken(token);
			UserDetails usuario = usuarioRepository.findByLogin(login);

			var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(autenticacao);
		}
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		var header = request.getHeader("Authorization");
		if (header == null) {
			return null;
		}

		return header.replace("Bearer ", "");
	}

}
