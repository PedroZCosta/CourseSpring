package com.example.CourseSpring.repositories;

import com.example.CourseSpring.entities.Category;
import com.example.CourseSpring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// nao preciso da notation do component pois o JpaRepository ja tem isso!
public interface ProductRepository extends JpaRepository<Product, Long> {

}
