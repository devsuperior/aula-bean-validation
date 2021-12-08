package com.devsuperior.aula.dto;

import javax.validation.constraints.Pattern;

public class UserInsertDTO extends UserDTO {
	
	@Pattern(regexp = "^(?=.*\\d).{4,8}$", message = "Campo password deve ter entre 4 e 8 caracteres e conter pelo menos um valo numérico")
	private String password;
	
	public UserInsertDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
