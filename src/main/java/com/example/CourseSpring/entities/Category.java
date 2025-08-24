package com.example.CourseSpring.entities;

import com.example.CourseSpring.repositories.CategoryRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table (name = "tb_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L; // Se a classe for modificada (por exemplo, adicionando um novo atributo) e você tentar carregar um objeto serializado anteriormente sem esse identificador fixo, um erro pode ocorrer. O serialVersionUID evita esse problema

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // deixa como autoIncrement
    private Long id;
    private String name;


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
