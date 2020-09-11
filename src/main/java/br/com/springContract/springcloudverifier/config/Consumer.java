package br.com.springContract.springcloudverifier.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class Consumer {

//     O objeto está sendo consumido como string pois foi criado somente para garantir se a mensagem
//      foi publicada com sucesso
    @KafkaListener(topics = "${cloudkarafka.topic}")
    public void processMessage(Object message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.printf("Mensagem consumida do tópico %s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
    }

}
