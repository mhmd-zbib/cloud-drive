package dev.zbib.drive.infrastructure.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RabbitListener(containerFactory = RabbitMqConfig.BATCH_FACTORY)
public @interface RabbitBatchListener {
    String[] queues();
}
