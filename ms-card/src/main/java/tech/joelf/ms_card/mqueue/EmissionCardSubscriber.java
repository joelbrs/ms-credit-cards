package tech.joelf.ms_card.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissionCardSubscriber {

    @RabbitListener(queues = "${mq.queues.cards-emissions}")
    public void receiveSolicitationEmission(@Payload String payload) {
        System.out.println(payload);
    }
}
