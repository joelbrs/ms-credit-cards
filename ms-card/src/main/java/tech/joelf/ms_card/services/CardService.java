package tech.joelf.ms_card.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tech.joelf.ms_card.dtos.CreateCardRequest;
import tech.joelf.ms_card.models.Card;
import tech.joelf.ms_card.repositories.CardRepository;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional
    public Card create(CreateCardRequest card) {
        return cardRepository.save(card.toModel());
    }

    public List<Card> getCardsLessThanEqual(Long income) {
        return cardRepository.findByIncomeLessThanEqual(income);
    }
}
