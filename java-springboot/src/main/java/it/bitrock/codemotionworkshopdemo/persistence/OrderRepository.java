package it.bitrock.codemotionworkshopdemo.persistence;

import it.bitrock.codemotionworkshopdemo.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByClient(String title);

}