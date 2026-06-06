package dev.zbib.drive.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@KafkaListener(containerFactory = KafkaConfig.BATCH_FACTORY)
public @interface KafkaBatchListener {
    String[] topics();
}