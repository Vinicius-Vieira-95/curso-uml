package com.curso.vnc.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.curso.vnc.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	
	UserDetails findByLogin(String login);
}
