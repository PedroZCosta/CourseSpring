package com.example.CourseSpring.resources;

import com.example.CourseSpring.entities.Product;
import com.example.CourseSpring.entities.User;
import com.example.CourseSpring.services.ProductService;
import com.example.CourseSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // responsáveis por lidar com requisições HTTP (como GET, POST, PUT, DELETE) e retornar dados diretamente no corpo da resposta
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired // Spring faz a injeção de dependencia
    private ProductService service;

    @GetMapping()
    public ResponseEntity<List<Product>> findAll(){ // metodo que é um endpoint para acessar os usuarios
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list); // retorna o corpo da resposta esse usuario que acabei de instanciar
    }


    @GetMapping(value = "/{id}") // obvio ne o get do /id
        public ResponseEntity<Product> findById(@PathVariable Long id){ //  Indica que o metodo retorna uma resposta HTTP que envolve um objeto User.
        Product obj = service.findById(id); // Provavelmente chama um serviço que contém a lógica para buscar o usuário no banco de dados. Essa função deve estar implementada na camada de serviço (Service Layer) e pode usar um repositório (Repository Layer) para essa busca.
        return ResponseEntity.ok().body(obj);
    }

}
