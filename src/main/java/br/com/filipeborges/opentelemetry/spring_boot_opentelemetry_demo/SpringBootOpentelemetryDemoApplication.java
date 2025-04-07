package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.repository.relational")
@EnableMongoRepositories(basePackages = "br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.repository.nosql")
public class SpringBootOpentelemetryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOpentelemetryDemoApplication.class, args);
	}

}
