package com.example.CourseSpring.repositories;

import com.example.CourseSpring.entities.Order;
import com.example.CourseSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
