package com.example.CourseSpring.entities;

import com.example.CourseSpring.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L; // Se a classe for modificada (por exemplo, adicionando um novo atributo) e você tentar carregar um objeto serializado anteriormente sem esse identificador fixo, um erro pode ocorrer. O serialVersionUID evita esse problema

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    private Integer quantity;
    private Double price;

    public OrderItem() {
    }


    // sem a pk
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    // lidando com o id da classe pk
    @JsonIgnore // é aqui q tem q botar para ele nn dar o problema ciclico la de um chamar o outro
    // pois e aqui q acessa a classe order chama o order q chama o pedido
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

