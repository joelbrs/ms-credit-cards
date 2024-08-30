package tech.joelf.ms_credit_assessor.dtos;

import java.util.Collections;
import java.util.List;

import tech.joelf.ms_credit_assessor.models.ApprovedCard;

public class ClientAssessmentReturnResponse {
    private List<ApprovedCard> cards;

    public ClientAssessmentReturnResponse(List<ApprovedCard> cards) {
        this.cards = cards;
    }

    public List<ApprovedCard> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void setCards(List<ApprovedCard> cards) {
        this.cards = cards;
    }
}
