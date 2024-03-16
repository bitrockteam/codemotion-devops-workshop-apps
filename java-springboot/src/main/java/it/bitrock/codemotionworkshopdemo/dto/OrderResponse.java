package it.bitrock.codemotionworkshopdemo.dto;

import it.bitrock.codemotionworkshopdemo.model.Order;

import java.time.LocalDate;

public class OrderResponse {

    private String id;
    private String customer;
    private String product;
    private Long quantity;
    private LocalDate creationDate;

    public OrderResponse(String id, String customer, String product, Long quantity, LocalDate creationDate) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.creationDate = creationDate;
    }

    public String getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String getProduct() {
        return this.product;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public static OrderResponse from(Order order) {
         return new OrderResponse(order.getId(), order.getCustomer(), order.getProduct(), order.getQuantity(), order.getCreationDate());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + id + ", " + customer + ", " + product + ", " + quantity + ", " + creationDate + ")";
    }
}