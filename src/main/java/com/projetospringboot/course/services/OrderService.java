package com.projetospringboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetospringboot.course.entities.Order;
import com.projetospringboot.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired //o spring faz a injeçao de depenciada de forma transparente ao programador
	private OrderRepository repository; //o OrderService tem dependencia no OrderRepository
	
	//metodo para retornar todos os usuarios do banco de dados
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	//retornar usuarios pelo id
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // retorna o objeto do tipo Order q esta dentro do optional
	}

}
