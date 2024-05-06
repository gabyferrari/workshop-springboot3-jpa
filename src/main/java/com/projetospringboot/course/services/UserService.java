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
	
	//operaçao para salvar no banco de dados um dado usuario
	public User insert(User obj) { //inserir um novo obj do tipo user
		return repository.save(obj);
	}
	
	//para deletar um usuario do banco de dados
	public void delete(Long id) { //passa o id do usuario e deleta do banco o usuario q tiver esse id
		repository.deleteById(id);
	}

}
