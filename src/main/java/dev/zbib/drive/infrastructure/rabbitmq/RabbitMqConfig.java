package dev.zbib.drive.infrastructure.rabbitmq;

import com.rabbitmq.client.AMQP.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public Queue eventsQueue() {
        return QueueBuilder.durable()
    }

}
