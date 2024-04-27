package com.curso.vnc.domain;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.curso.vnc.domain.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String login;

	private String senha;

	private Role role;

	public Usuario() {
	}

	public Usuario(String login, String senha, Role role) {
		super();
		this.login = login;
		this.senha = senha;
		this.role = role;
	}

	public Usuario(UUID id, String login, String senha, Role role) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == Role.ADMIN) {
			return List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USUARIO"));
		}
		else {
			return List.of(new SimpleGrantedAuthority("USUARIO"));
		}
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
