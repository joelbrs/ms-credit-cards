package tech.joelf.ms_card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCardApplication.class, args);
	}
}
