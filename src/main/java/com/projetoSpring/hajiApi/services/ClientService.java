package com.projetoSpring.hajiApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpring.hajiApi.entities.Client;
import com.projetoSpring.hajiApi.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll(){
		List<Client> result =  clientRepository.findAll();
		return result;
	}
}
