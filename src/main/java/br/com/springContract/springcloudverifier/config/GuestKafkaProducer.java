package br.com.springContract.springcloudverifier.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class GuestKafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${cloudkarafka.topic}")
    private String topic;

    GuestKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Object message) {
        this.kafkaTemplate.send(topic, message);
        System.out.println("Mensagem enviada [" + message + "] para tópico " + topic);
    }

}