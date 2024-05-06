package com.example.kafkacloudstream.service.stream;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
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
  public void sendMessagePayment(Object payload) {
    Map<String, Object> headers = new HashMap<>();
    headers.put("appName", "BackOffice");
    headers.put("callerName", "bb2-msa-bs-guided-experience");

    Message<Object> message = MessageBuilder
        .withPayload(payload)
        .copyHeaders(headers)
        .build();
    streamBridge.send("payment-out-0", message);
    log.info("===> sendMessage ");
    streamBridge.send("payment-out-0", payload);
  }


}
