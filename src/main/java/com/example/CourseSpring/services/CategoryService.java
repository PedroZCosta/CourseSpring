package com.example.CourseSpring.services;

import com.example.CourseSpring.entities.Category;
import com.example.CourseSpring.entities.User;
import com.example.CourseSpring.repositories.CategoryRepository;
import com.example.CourseSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Component // autoriza a injecao dessa classe em outras como dependencia
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id); // O tipo Optional é uma classe do Java que representa um valor que pode ou não estar presente. Ele é usado para evitar NullPointerException.
        return obj.get(); // O metodo .get() tenta extrair o valor presente dentro do Optional.
    }

}
