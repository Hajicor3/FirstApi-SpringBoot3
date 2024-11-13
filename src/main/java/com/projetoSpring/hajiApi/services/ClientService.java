package com.projetoSpring.hajiApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoSpring.hajiApi.dto.ClientDTO;
import com.projetoSpring.hajiApi.entities.Client;
import com.projetoSpring.hajiApi.repositories.ClientRepository;

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
		Client result = clientRepository.findById(id).get();
		return new ClientDTO(result);
	}
	
	@Transactional
	public Client addClient(Client obj) {
		return clientRepository.save(obj);
	}
	
	@Transactional
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}
	
	@Transactional
	public void updateClient(Long id, Client obj) {
		Client old = clientRepository.getReferenceById(id);
		updateData(obj,old);
		
	}
	
	private void updateData(Client update, Client old ) {
		
		old.setName(update.getName());
		old.setCep(update.getCep());
		old.setAdress(update.getAdress());
		old.setPhoneNumber(update.getPhoneNumber());
		old.setPassword(update.getPassword());
		old.setEmail(update.getEmail());
	}
}
