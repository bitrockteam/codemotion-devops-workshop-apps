package it.bitrock.codemotionworkshopdemo.service;

import it.bitrock.codemotionworkshopdemo.dto.OrderRequest;
import it.bitrock.codemotionworkshopdemo.dto.OrderResponse;
import it.bitrock.codemotionworkshopdemo.repository.OrderRepository;
import it.bitrock.codemotionworkshopdemo.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

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

    public Optional<OrderResponse> save(OrderRequest request) {
        try {
            ResponseEntity<String> result = defaultClient.get().uri(orderValidatorEndpoint).retrieve().toEntity(String.class);
            if (result.getStatusCode().is2xxSuccessful()) {
                Order order = OrderRequest.toOrder(request);
                orderRepository.save(order);
                return Optional.of(OrderResponse.from(order));
            } else {
                return Optional.empty();
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                return Optional.empty();
            } else {
                throw new RuntimeException("Unexpected error");
            }
        }
    }
}
