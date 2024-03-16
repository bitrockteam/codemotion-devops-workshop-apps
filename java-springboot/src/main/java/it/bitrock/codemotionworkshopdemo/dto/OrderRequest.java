package it.bitrock.codemotionworkshopdemo.dto;

import it.bitrock.codemotionworkshopdemo.model.Order;

import java.time.LocalDate;

public class OrderRequest {

    private final String customer;
    private final String product;
    private final Long quantity;

    public OrderRequest(String customer, String product, Long quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
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

    public static Order toOrder(OrderRequest orderRequest) {
        return new Order(orderRequest.getCustomer(), orderRequest.getProduct(), orderRequest.getQuantity(), LocalDate.now());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + customer + ", " + product + ", " + quantity + ")";
    }
}