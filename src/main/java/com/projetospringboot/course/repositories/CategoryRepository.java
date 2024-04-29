package com.projetospringboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringboot.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{


}
