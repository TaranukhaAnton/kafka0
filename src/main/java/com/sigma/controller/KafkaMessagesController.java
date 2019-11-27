package com.sigma.controller;

import com.sigma.kafka.producer.Sender;
import com.sigma.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/send")
public class KafkaMessagesController {
    public static final Logger logger = LoggerFactory.getLogger(KafkaMessagesController.class);

    @Autowired
    private Sender sender;

    @GetMapping(value = "foo")
    public ResponseEntity<?> sendFoo(@RequestParam(name = "message") String message,  @RequestParam(name = "topic") String topic) {
        logger.info("Fetching all brands");
        sender.send(topic, message);
        return new ResponseEntity<PagedResources>( HttpStatus.OK);
    }
    @GetMapping(value = "greeting")
    public ResponseEntity<?> sendGreeting(@RequestParam(name = "message") String message,
                                          @RequestParam(name = "name") String name,
                                          @RequestParam(name = "topic") String topic) {
        logger.info("Fetching all brands");
        Greeting payload = new Greeting();
        payload.setMsg(message);
        payload.setName(name);
        sender.send(topic, payload);
        return new ResponseEntity<PagedResources>( HttpStatus.OK);
    }


}
