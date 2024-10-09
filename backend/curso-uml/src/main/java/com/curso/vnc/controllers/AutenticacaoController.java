package com.curso.vnc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.vnc.config.TokenConfig;
import com.curso.vnc.domain.Usuario;
import com.curso.vnc.domain.dto.AutenticaoDto;
import com.curso.vnc.domain.dto.CadastroDto;
import com.curso.vnc.domain.dto.LoginTokenDto;
import com.curso.vnc.repositories.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TokenConfig tokenConfig;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AutenticaoDto data) {
		var usuarioSenha = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
		var auth = authenticationManager.authenticate(usuarioSenha);

		var token = tokenConfig.Gerartoken((Usuario) auth.getPrincipal());

		return ResponseEntity.ok().body(new LoginTokenDto(token));
	}

	@PostMapping("/cadastro")
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroDto data) {

		if (this.usuarioRepository.findByLogin(data.login()) != null) {
			return ResponseEntity.badRequest().build();
		}

		var senhaEnciptada = new BCryptPasswordEncoder().encode(data.senha());
		var novoUsuario = new Usuario(data.login(), senhaEnciptada, data.role());
		usuarioRepository.save(novoUsuario);

		return ResponseEntity.ok().build();
	}
}
