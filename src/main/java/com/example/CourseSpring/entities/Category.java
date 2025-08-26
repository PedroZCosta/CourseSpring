package com.example.CourseSpring.entities;

import com.example.CourseSpring.repositories.CategoryRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "tb_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L; // Se a classe for modificada (por exemplo, adicionando um novo atributo) e você tentar carregar um objeto serializado anteriormente sem esse identificador fixo, um erro pode ocorrer. O serialVersionUID evita esse problema

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // deixa como autoIncrement
    private Long id;
    private String name;

    // por ser uma relacao bidirecional ele chama uma lista q chama a outra e a biblbioteca buga tudo
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();


    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
