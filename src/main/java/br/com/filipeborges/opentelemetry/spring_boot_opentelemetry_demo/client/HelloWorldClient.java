package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class HelloWorldClient {

    private WebClient webClient;

    public HelloWorldClient(
            WebClient.Builder builder,
            @Value("${app.hello-world.url:http://localhost:8080}") String helloWorldBaseUrl
    ) {
        this.webClient = builder.baseUrl(helloWorldBaseUrl).build();
    }

    public Mono<String> getHelloWorld() {
        return webClient
                .get()
                .uri("/hello-world")
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .bodyToMono(String.class);
    }

}
