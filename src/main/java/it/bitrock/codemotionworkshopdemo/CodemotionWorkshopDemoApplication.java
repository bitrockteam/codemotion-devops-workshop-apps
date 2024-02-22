package it.bitrock.codemotionworkshopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CodemotionWorkshopDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(CodemotionWorkshopDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CodemotionWorkshopDemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		logger.info("Answering to an Hello");
		return "Hello";
	}
}
