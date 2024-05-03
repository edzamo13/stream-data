# Event hub Kafka


 ### Multi binder two kafka-clusters/src/main/resources


## Table of Contents
1. [One Binder and Brocker](#one-binder)
2. [Multi binder same broker](#multi-buinder)
7. [FAQs](#faqs)

***
### one-binder

- Yaml application.yml  :

```bash
spring:
  cloud:
    stream:
      kafka:
        binder:
          brokers: ${host}:${port}
          configuration:
            sasl:
              mechanism: PLAIN
              jaas:
                config: ${password}
            security:
              protocol: SASL_SSL
      bindings:
        receive-in-0:
          destination: hub-csm-file-report-queue
        supply-out-0:
          destination: hub-csm-file-report-queue
    function:
      definition: receive
```
- Class stream
  - Bridge
- Consumer
- Procedure


***
## multi-buinder

Configuration multi binders with different configuration Jaas
- Yaml application-local.yml  :

```bash

spring:
  cloud:
    function:
      definition: receive;consume # Definición de las funciones que se utilizarán
    stream:
      bindings:
        payment-out-0:
          destination: hub-csm-file-payment-event
          binder: kafka1  # Configuración del binder kafka1 para este binding
        receive-in-0:
          destination: hub-csm-file-payment-event
          binder: kafka1  # Configuración del binder kafka1 para este binding
        report-out-0:
          destination: hub-csm-file-report-queue
          binder: kafka2  # Configuración del binder kafka2 para este binding
        consume-in-0:
          destination: hub-csm-file-report-queue
          binder: kafka2  # Configuración del binder kafka2 para este binding

      # Configuración personalizada de los binders kafka1 y kafka2
      kafka:
        binder:
          brokers: ${host}:${port}
          configuration:
            security.protocol: SASL_SSL
            sasl.mechanism: PLAIN
            sasl.jaas.config: ${kafka.jaas.config}

      binders:
        kafka1:
          type: kafka
          environment:
            kafka:
              jaas:
                config:  ${password1}

        kafka2:
          type: kafka
          environment:
            kafka:
              jaas:
                config:  ${password2}

```

- Class stream
    - Bridge
- Consumer
- Procedure

***



## FAQs
***
A list of frequently asked questions
1. **This is a question in bold**
   Answer of the first question with _italic words_.
* Documentation Spring Cloud
  https://github.com/spring-cloud/spring-cloud-stream-samples



