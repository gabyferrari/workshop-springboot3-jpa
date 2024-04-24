package com.projetospringboot.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospringboot.course.entities.User;
import com.projetospringboot.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//controlador rest que responde no caminho users
	
	@Autowired
	private UserService service; //essa classe depende do userservice
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
    @GetMapping(value = "/{id}") //indica q a minha requisiçao vai aceitar um id dentro da url
    public ResponseEntity<User> findById(@PathVariable Long id) {
    	User obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
}
