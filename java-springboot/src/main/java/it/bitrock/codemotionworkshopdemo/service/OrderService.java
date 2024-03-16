package it.bitrock.codemotionworkshopdemo.service;

import it.bitrock.codemotionworkshopdemo.dto.OrderRequest;
import it.bitrock.codemotionworkshopdemo.dto.OrderResponse;
import it.bitrock.codemotionworkshopdemo.repository.OrderRepository;
import it.bitrock.codemotionworkshopdemo.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private RestClient defaultClient = RestClient.create();
    @Value("${order-validator.endpoint}")
    private String orderValidatorEndpoint;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream().map(OrderResponse::from).toList();
    }

    public OrderResponse save(OrderRequest request) {
        ResponseEntity<String> result = defaultClient.get().uri(orderValidatorEndpoint).retrieve().toEntity(String.class);
        if (result.getStatusCode().is2xxSuccessful()) {
            Order order = OrderRequest.toOrder(request);
            orderRepository.save(order);
            return OrderResponse.from(order);
        } else {
           throw new RuntimeException("Failed to validate order");
        }
    }
}
