package com.projetoSpring.hajiApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpring.hajiApi.dto.ClientDTO;
import com.projetoSpring.hajiApi.entities.Client;
import com.projetoSpring.hajiApi.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<ClientDTO> findAll(){
		List<Client> result =  clientRepository.findAll();
		return result.stream().map( x -> new ClientDTO(x)).toList();
	}
	
	public ClientDTO findById(Long id){
		Client result = clientRepository.findById(id).get();
		return new ClientDTO(result);
	}
	
	public Client addClient(Client obj) {
		return clientRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}
}
