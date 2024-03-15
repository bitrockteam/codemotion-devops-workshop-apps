package it.bitrock.codemotionworkshopdemo.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "'Order'")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String client;
    private String resource;
    private LocalDate creationDate;

    // for JPA only, no use
    public Order() {
    }

    public Order(String client, String resource, LocalDate date) {
        this.client = client;
        this.resource = resource;
        this.creationDate = date;
    }

    public Long getId() {
        return this.id;
    }

    public String getClient() {
        return client;
    }

    public String getResource() {
        return resource;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}