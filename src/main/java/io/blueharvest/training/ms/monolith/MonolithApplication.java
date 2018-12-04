package io.blueharvest.training.ms.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MonolithApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonolithApplication.class, args);
	}
}
