package com.example.kafkacloudstream;

import com.example.kafkacloudstream.service.ProduceEvents;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SendMessageController {

  private final ProduceEvents produceEvents;

  @PostMapping("api/send")
  public Mono<ResponseEntity<String>> sendMessage() {

    log.info("try send message !..");
    this.produceEvents.sendPayment("I send Message.. supply-out-0:destination: hub-csm-file-payment-event");


    return Mono.just("hola")
        .map(ResponseEntity::ok);
  }

}
