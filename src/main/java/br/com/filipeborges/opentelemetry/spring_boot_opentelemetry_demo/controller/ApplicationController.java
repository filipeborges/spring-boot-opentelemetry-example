package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.controller;

import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.client.HelloWorldClient;
import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.model.HelloWorld;
import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.repository.relational.HelloWorldRepository;
import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class ApplicationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    private HelloWorldRepository helloWorldRepository;
    private AuditService auditService;
    private HelloWorldClient helloWorldClient;

    public ApplicationController(
            HelloWorldRepository helloWorldRepository,
            HelloWorldClient helloWorldClient,
            AuditService auditService
    ) {
        this.helloWorldRepository = helloWorldRepository;
        this.helloWorldClient = helloWorldClient;
        this.auditService = auditService;
    }

    @GetMapping(value = "/hello-world", produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> helloWorld() {
        LOGGER.debug("Will return hello world data");
        return Mono.just("Hello World");
    }

    @GetMapping(value = "/hello-world/uppercase", produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> helloWorldUpperCase() {
        LOGGER.debug("Will return hello world uppercase data");
        return helloWorldClient.getHelloWorld()
                .map(String::toUpperCase);
    }

    @PostMapping(value = "/hello-world", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<HelloWorld> createHelloWorld(
            @RequestBody HelloWorld helloWorld,
            ServerHttpRequest request
    ) {
        LOGGER.debug("Will create hello world");
        return helloWorldRepository.save(helloWorld)
                .zipWhen(hW -> auditService.audit(request.getRemoteAddress().getAddress().getHostAddress(), hW.getId()))
                .map(Tuple2::getT1);
    }
}
