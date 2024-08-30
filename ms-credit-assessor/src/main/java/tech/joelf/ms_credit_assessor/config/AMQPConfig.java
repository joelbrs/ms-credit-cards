package tech.joelf.ms_credit_assessor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {

    @Value("${mq.queue.cards-emissions}")
    private String queueEmisstionCardsName;

    @Bean
    public Queue queueEmissionCards() {
        return new Queue(queueEmisstionCardsName, true);
    }
}
