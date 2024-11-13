package com.projetoSpring.hajiApi.entities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpring.hajiApi.dto.ClientDTO;
import com.projetoSpring.hajiApi.entities.Client;
import com.projetoSpring.hajiApi.services.ClientService;

@RestController
@RequestMapping(value = "/users")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<ClientDTO> findAll() {
		List<ClientDTO> result = clientService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public ClientDTO findById (@PathVariable Long id) {
		ClientDTO result = clientService.findById(id);
		return result;
	}
	
	@PostMapping
	public Client addClient(@RequestBody Client obj) {
		return clientService.addClient(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		clientService.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateClient(@PathVariable Long id, @RequestBody Client obj) {
		clientService.updateClient(id, obj);
	}
	
}
