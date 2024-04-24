package com.projetospringboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringboot.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//nao precisa implementar pois o JpaRepository ja faz isso
}
