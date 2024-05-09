package com.projetospringboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetospringboot.course.entities.User;
import com.projetospringboot.course.repositories.UserRepository;
import com.projetospringboot.course.services.exceptions.DatabaseException;
import com.projetospringboot.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // retorna o objeto do tipo User q esta dentro do optional
	}
	
	//operaçao para salvar no banco de dados um dado usuario
	public User insert(User obj) { //inserir um novo obj do tipo user
		return repository.save(obj);
	}
	
	//para deletar um usuario do banco de dados
	public void delete(Long id) { //passa o id do usuario e deleta do banco o usuario q tiver esse id
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	//para atualizar um dado usuario
	public User update(Long id, User obj) { //qual o usuario do banco vai atualizar e o User contendo os dados q irao atualizar
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}

}
