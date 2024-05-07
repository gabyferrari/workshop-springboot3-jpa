package com.projetospringboot.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetospringboot.course.entities.User;
import com.projetospringboot.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//controlador rest que responde no caminho users
	
	@Autowired
	private UserService service; //essa classe depende do userservice
	
	@GetMapping //Get = recuperar dados do banco
	public ResponseEntity<List<User>> findAll() { //buscar todos os usuarios no banco
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
    @GetMapping(value = "/{id}") //indica q a minha requisiçao vai aceitar um id dentro da url / vai retornar um usuario especifico pelo id
    public ResponseEntity<User> findById(@PathVariable Long id) {
    	User obj = service.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping //Post = inserir dados no banco
    public ResponseEntity<User> insert(@RequestBody User obj) {
    	obj = service.insert(obj);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") //para dar status:201 no postman
    			.buildAndExpand(obj.getId()).toUri();
    	return ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
    	obj = service.update(id, obj);
    	return ResponseEntity.ok().body(obj);
    }
}
