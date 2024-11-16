package com.projetoSpring.hajiApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoSpring.hajiApi.dto.ClientDTO;
import com.projetoSpring.hajiApi.entities.Client;
import com.projetoSpring.hajiApi.repositories.ClientRepository;
import com.projetoSpring.hajiApi.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> result =  clientRepository.findAll();
		return result.stream().map( x -> new ClientDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id){
		Client result = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return new ClientDTO(result);
	}
	
	@Transactional
	public Client addClient(Client obj) {
		return clientRepository.save(obj);
	}
	
	@Transactional
	public void deleteById(Long id) {
		
		if(!clientRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		clientRepository.deleteById(id);
	}
	
	@Transactional
	public Client updateClient(Long id, Client obj) {
		try {
		Client old = clientRepository.getReferenceById(id);
		updateData(obj,old);
		return clientRepository.save(old);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	@Transactional
	private void updateData(Client update, Client old ) {
		
		old.setName(update.getName());
		old.setCep(update.getCep());
		old.setAdress(update.getAdress());
		old.setPhoneNumber(update.getPhoneNumber());
		old.setPassword(update.getPassword());
		old.setEmail(update.getEmail());
		old.setBirthDate(update.getBirthDate());
	}
}
