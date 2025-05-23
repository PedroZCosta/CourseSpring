package com.example.CourseSpring.services;

import java.util.List;
import java.util.Optional;

import com.example.CourseSpring.entities.User;
import com.example.CourseSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Component // autoriza a injecao dessa classe em outras como dependencia
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id); // O tipo Optional é uma classe do Java que representa um valor que pode ou não estar presente. Ele é usado para evitar NullPointerException.
        return obj.get(); // O metodo .get() tenta extrair o valor presente dentro do Optional.
    }

}
