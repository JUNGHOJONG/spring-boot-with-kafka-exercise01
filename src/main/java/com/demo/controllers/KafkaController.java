package com.demo.controllers;

import com.demo.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/kafka")
@RestController
public class KafkaController {

    private final Producer producer;

    @Autowired
    private KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        System.out.println("KafkaController.sendMessageToKafkaTopic");
        this.producer.sendMessage(message);
    }
}
