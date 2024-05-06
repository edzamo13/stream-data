package com.example.kafkacloudstream.controller;

import com.example.kafkacloudstream.domain.message.Payload;
import com.example.kafkacloudstream.service.ProduceEvents;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SendMessageController {

  private final ProduceEvents produceEvents;

  @PostMapping(value = "api/send")
  public Mono<ResponseEntity<String>> sendMessage(@RequestBody Payload payload) {

  // this.produceEvents.sendReport("I send Message.. for report-out-0: test 2-05-2014 ");
    log.info("Queue ..send Payment ");
    this.produceEvents.sendPayment(payload);

    return Mono.just("hola")
        .map(ResponseEntity::ok);
  }

}

