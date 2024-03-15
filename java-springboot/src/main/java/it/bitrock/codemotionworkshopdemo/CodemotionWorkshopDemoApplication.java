package it.bitrock.codemotionworkshopdemo;

import it.bitrock.codemotionworkshopdemo.model.OrderRequest;
import it.bitrock.codemotionworkshopdemo.persistence.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class CodemotionWorkshopDemoApplication {

	@Autowired
	private OrderService orderService;

	private static final Logger logger = LoggerFactory.getLogger(CodemotionWorkshopDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CodemotionWorkshopDemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		logger.info("Answering to an Hello");
		return "Hello";
	}

	@GetMapping("/orders")
	public List<Order> getOrders() {
		logger.info("Retrieving orders");
		return orderService.findAll();
	}

	@PostMapping("/orders")
	public Order createOrder(@RequestBody OrderRequest request) {
		logger.info("Creating order orders from " + request.toString());
		return orderService.save(request);
	}
}
