package com.curso.vnc.domain.dto;

import com.curso.vnc.domain.enums.Role;

public record CadastroDto(String login, String senha, Role role) {

}
