package dev.zbib.drive.modules.changes;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChangesRabbitMqConfig {

    public static final String QUEUE    = "changes.queue";
    public static final String EXCHANGE = "changes.exchange";
    public static final String ROUTING_KEY = "changes.key";

    @Bean
    public Queue changesQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public DirectExchange changesExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding changesBinding(Queue changesQueue, DirectExchange changesExchange) {
        return BindingBuilder.bind(changesQueue).to(changesExchange).with(ROUTING_KEY);
    }
}
