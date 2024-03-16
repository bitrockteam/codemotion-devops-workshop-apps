package it.bitrock.codemotionworkshopdemo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "'order'")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String customer;
    private String product;
    private Long quantity;
    private LocalDate creationDate;

    public Order() {}

    public Order(String customer, String product, Long quantity, LocalDate date) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.creationDate = date;
    }

    public String getId() {
        return this.id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}