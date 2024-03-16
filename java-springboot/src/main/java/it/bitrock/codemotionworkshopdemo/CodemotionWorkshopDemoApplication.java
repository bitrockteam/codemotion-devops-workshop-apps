package it.bitrock.codemotionworkshopdemo;

import it.bitrock.codemotionworkshopdemo.dto.OrderRequest;
import it.bitrock.codemotionworkshopdemo.dto.OrderResponse;
import it.bitrock.codemotionworkshopdemo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class CodemotionWorkshopDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(CodemotionWorkshopDemoApplication.class);

	private final OrderService orderService;

	public CodemotionWorkshopDemoApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CodemotionWorkshopDemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		logger.info("Answering to an Hello");
		return "Hello";
	}

	@GetMapping("/orders")
	public List<OrderResponse> getOrders() {
		logger.info("Retrieving orders");
		return orderService.findAll();
	}

	@PostMapping("/orders")
	public OrderResponse createOrder(@RequestBody OrderRequest request) {
		logger.info("Creating order from " + request.toString());
		return orderService.save(request);
	}
}
