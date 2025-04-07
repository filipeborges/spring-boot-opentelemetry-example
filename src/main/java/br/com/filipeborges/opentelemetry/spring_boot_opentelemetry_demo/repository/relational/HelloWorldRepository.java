package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.repository.relational;

import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.model.HelloWorld;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends ReactiveCrudRepository<HelloWorld, Long> {
}
