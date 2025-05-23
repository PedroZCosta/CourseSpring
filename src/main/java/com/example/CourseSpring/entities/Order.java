package com.example.CourseSpring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Entity
@Table (name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L; // Se a classe for modificada (por exemplo, adicionando um novo atributo) e você tentar carregar um objeto serializado anteriormente sem esse identificador fixo, um erro pode ocorrer. O serialVersionUID evita esse problema


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // deixa como autoIncrement
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // Garante a formatacao correta do instant
    private Instant moment;

    @ManyToOne // vários pedidos (Orders) pertencem a um mesmo cliente (User)
    @JoinColumn(name = "client_id")
    private User client;

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
