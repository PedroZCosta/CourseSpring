package com.example.CourseSpring.services;

import com.example.CourseSpring.entities.Product;
import com.example.CourseSpring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Component // autoriza a injecao dessa classe em outras como dependencia
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id); // O tipo Optional é uma classe do Java que representa um valor que pode ou não estar presente. Ele é usado para evitar NullPointerException.
        return obj.get(); // O metodo .get() tenta extrair o valor presente dentro do Optional.
    }

}
