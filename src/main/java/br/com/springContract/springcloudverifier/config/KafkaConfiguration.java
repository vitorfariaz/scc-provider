//package br.com.springContract.springcloudverifier.config;
//
//import br.com.springContract.springcloudverifier.model.Convidado;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaConfiguration {
//
//    @Bean
//    public ProducerFactory producerFactory(){
//        Map<String, Object> config = new HashMap<>();
//
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "omnibus-01.srvs.cloudkafka.com:9094");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return  new DefaultKafkaProducerFactory(config);
//
//    }
//
//    @Bean
//    public KafkaTemplate<String, Convidado> kafkaTemplate(){
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//}
