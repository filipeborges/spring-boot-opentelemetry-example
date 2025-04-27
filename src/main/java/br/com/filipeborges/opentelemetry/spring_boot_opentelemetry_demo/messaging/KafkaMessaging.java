package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.messaging;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.ThreadLocalRandom;

@Configuration
@EnableScheduling
public class KafkaMessaging {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessaging.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${application.messaging.kafka.topic}")
    private String topic;

    @Bean
    public NewTopic createApplicationTopic() {
        return TopicBuilder.name(topic)
                .partitions(1)
                .build();
    }

    @KafkaListener(groupId = "${spring.application.name}", topics = "${application.messaging.kafka.topic}")
    public void consumeMessage(String message) {
        LOGGER.debug("Consuming hello world event");
        LOGGER.info("==========> {}", message);
    }

    @Scheduled(fixedDelay = 5000)
    public void produceMessage() {
        LOGGER.debug("Producing hello world event");
        kafkaTemplate.send(topic, "hello world event - " + ThreadLocalRandom.current().nextInt(101));
    }

}
