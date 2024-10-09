package com.curso.vnc.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.curso.vnc.domain.Usuario;

@Service
public class TokenConfig {

	@Value("${api.security.token.secret}")
	private String palavraChave;

	public String Gerartoken(Usuario usuario) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(palavraChave);

			String token = JWT.create().withSubject(usuario.getLogin())
					.withIssuer("api-uml")
					.withExpiresAt(gerarTempoExpiracao())
					.sign(algorithm);

			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro ao criar token de autenticação " + e);
		}
	}
	
	public String validarToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(palavraChave);
			return JWT.require(algorithm)
					.withIssuer("api-uml")
					.build()
					.verify(token)
					.getSubject();
		}
		catch(JWTVerificationException e) {
			return "";
		}
	}

	private Instant gerarTempoExpiracao() {
		return LocalDateTime.now().atZone(ZoneId.systemDefault()).plusHours(2).toInstant();
	}
}
