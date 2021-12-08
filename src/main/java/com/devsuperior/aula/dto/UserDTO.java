package com.devsuperior.aula.dto;

import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.devsuperior.aula.entities.User;

public class UserDTO {

	private Long id;
	
	@NotBlank(message = "Valor não pode ser nulo ou vazio")
	private String name;
	
	@Email(message = "Campo de email inválido")
	private String email;
	
	@Size(min = 8, max = 16, message = "Campo phone deve ter entre 9 e 16 caracteres")
	private String phone;
	
	@PastOrPresent(message = "Campo de data inválida")
	private Instant birthDate;
	
	@Positive(message = "Campo saldo deve ser positivo")
	private Double balance;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String phone, Instant birthDate, Double balance) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.balance = balance;
	}
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		birthDate = user.getBirthDate();
		balance = user.getBalance();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
