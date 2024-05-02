package com.projetospringboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringboot.course.entities.OrderItem;
import com.projetospringboot.course.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
