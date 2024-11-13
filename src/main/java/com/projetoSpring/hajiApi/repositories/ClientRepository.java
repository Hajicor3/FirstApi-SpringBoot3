package com.projetoSpring.hajiApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpring.hajiApi.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
