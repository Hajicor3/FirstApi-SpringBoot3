package com.projetoSpring.hajiApi.dto;

import java.time.LocalDate;

import com.projetoSpring.hajiApi.entities.Client;

public class ClientDTO {
	
	private Long id;
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public ClientDTO() {
	}
	
	public ClientDTO(Client entity) {
		
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		birthDate = entity.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
}
