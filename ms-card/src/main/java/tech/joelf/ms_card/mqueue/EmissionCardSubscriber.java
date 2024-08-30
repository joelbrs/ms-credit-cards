package tech.joelf.ms_card.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.joelf.ms_card.models.Card;
import tech.joelf.ms_card.models.ClientCard;
import tech.joelf.ms_card.models.EmissionCardData;
import tech.joelf.ms_card.repositories.CardRepository;
import tech.joelf.ms_card.repositories.ClientCardRepository;

@Component
public class EmissionCardSubscriber {

    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    public EmissionCardSubscriber(CardRepository cardRepository, ClientCardRepository clientCardRepository) {
        this.cardRepository = cardRepository;
        this.clientCardRepository = clientCardRepository;
    }

    @RabbitListener(queues = "${mq.queues.cards-emissions}")
    public void receiveSolicitationEmission(@Payload String payload) {
        var mapper = new ObjectMapper();

        try {
            EmissionCardData data = mapper.readValue(payload, EmissionCardData.class);

            Card card = cardRepository.findById(data.getIdCard()).orElseThrow(RuntimeException::new);
            ClientCard clientCard = new ClientCard(null, data.getCpf(), card, data.getLiberatedLimit());

            clientCardRepository.save(clientCard);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
