package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.controller;

import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.client.HelloWorldClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ApplicationController {

    private HelloWorldClient helloWorldClient;

    public ApplicationController(HelloWorldClient helloWorldClient) {
        this.helloWorldClient = helloWorldClient;
    }

    @GetMapping(value = "/hello-world", produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> helloWorld() {
        return Mono.just("Hello World");
    }

    @GetMapping(value = "/hello-world/uppercase", produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> helloWorldUpperCase() {
        return helloWorldClient.getHelloWorld()
                .map(String::toUpperCase);
    }

}
