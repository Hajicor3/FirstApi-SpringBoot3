package com.projetoSpring.hajiApi.dto;

import java.time.LocalDate;

import com.projetoSpring.hajiApi.entities.Client;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClientDTO {
	
	private Long id;
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public ClientDTO(Client entity) {
		
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		birthDate = entity.getBirthDate();
	}
}
