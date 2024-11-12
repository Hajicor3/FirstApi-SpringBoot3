package com.projetoSpring.hajiApi.entities.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetoSpring.hajiApi.entities.Client;
import com.projetoSpring.hajiApi.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Client c1 = new Client(null,"Gabriel","123456","gabriel@gmail.com","88888-8888","passagem rosa 200","2865",LocalDate.parse("2001-07-04"));
		Client c2 = new Client(null,"joão","123456","joao2@gmail.com","88888-8888","passagem amarela 200","2865",LocalDate.parse("2010-02-10"));
		Client c3 = new Client(null,"Beatriz","123456","beatriz@gmail.com","88888-8888","passagem laranja 220","2865",LocalDate.parse("2007-01-22"));
		Client c4 = new Client(null,"Joana","123456","joana@gmail.com","88888-8888","passagem natal 200","2865",LocalDate.parse("1998-12-25"));
		
		
		clientRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
	}

}
