package com.curso.vnc.domain.enums;

public enum Role {
	
	ADMIN("ADMIN"),
	USUARIO("USUARIO");
	
	private String role;

	Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
