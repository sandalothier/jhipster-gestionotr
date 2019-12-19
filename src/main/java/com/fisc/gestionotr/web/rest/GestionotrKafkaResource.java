package com.fisc.gestionotr.web.rest;

import com.fisc.gestionotr.service.GestionotrKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gestionotr-kafka")
public class GestionotrKafkaResource {

    private final Logger log = LoggerFactory.getLogger(GestionotrKafkaResource.class);

    private GestionotrKafkaProducer kafkaProducer;

    public GestionotrKafkaResource(GestionotrKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
