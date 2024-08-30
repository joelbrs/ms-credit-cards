package tech.joelf.ms_credit_assessor;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class MsCreditAssessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCreditAssessorApplication.class, args);
	}
}
