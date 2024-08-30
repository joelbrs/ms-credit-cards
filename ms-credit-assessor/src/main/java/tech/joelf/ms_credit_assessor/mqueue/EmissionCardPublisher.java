package tech.joelf.ms_credit_assessor.mqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.joelf.ms_credit_assessor.models.EmissionCardData;

public class EmissionCardPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueEmissionCards;

    public EmissionCardPublisher(RabbitTemplate rabbitTemplate, Queue queueEmissionCards) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueEmissionCards = queueEmissionCards;
    }

    public void sendEmissionCard(EmissionCardData emissionCardData) throws JsonProcessingException {
        var json = covertIntoJSON(emissionCardData);
        rabbitTemplate.convertAndSend(queueEmissionCards.getName(), json);
    }

    private String covertIntoJSON(EmissionCardData data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
}