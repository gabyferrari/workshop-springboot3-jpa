package com.projetospringboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetospringboot.course.entities.User;
import com.projetospringboot.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired //o spring faz a injeçao de depenciada de forma transparente ao programador
	private UserRepository repository; //o UserService tem dependencia no UserRepository
	
	//metodo para retornar todos os usuarios do banco de dados
	public List<User> findAll() {
		return repository.findAll();
	}
	
	//retornar usuarios pelo id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); // retorna o objeto do tipo User q esta dentro do optional
	}

}
