package com.example.CourseSpring.repositories;

import com.example.CourseSpring.entities.OrderItem;
import com.example.CourseSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// nao preciso da notation do component pois o JpaRepository ja tem isso!
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
