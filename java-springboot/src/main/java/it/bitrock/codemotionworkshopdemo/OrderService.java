package it.bitrock.codemotionworkshopdemo;

import it.bitrock.codemotionworkshopdemo.model.OrderRequest;
import it.bitrock.codemotionworkshopdemo.persistence.OrderRepository;
import it.bitrock.codemotionworkshopdemo.persistence.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private RestClient defaultClient = RestClient.create();
    private String orderValidatorService = "http://sample-flask:8080/checkStorage";

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(OrderRequest request) {
        ResponseEntity<String> result = defaultClient.get().uri(orderValidatorService).retrieve().toEntity(String.class);
        if (result.getStatusCode().is2xxSuccessful()) {
            Order order = new Order(request.client(), request.resource(), LocalDate.now());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Failed to validate order");
        }

    }

}
