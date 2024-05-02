package com.example.kafkacloudstream.service.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class  Bridge {

  private final StreamBridge streamBridge;

  public void sendMessageReport(Object obj) {
    log.info("===> sendMessage ");
    streamBridge.send("report-out-0", obj);
  }
  public void sendMessagePayment(Object obj) {
    log.info("===> sendMessage ");
    streamBridge.send("payment-out-0", obj);
  }

}
