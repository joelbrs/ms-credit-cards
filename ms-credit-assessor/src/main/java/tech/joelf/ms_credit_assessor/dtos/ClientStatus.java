package tech.joelf.ms_credit_assessor.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tech.joelf.ms_credit_assessor.models.ClientCard;
import tech.joelf.ms_credit_assessor.models.ClientData;

public class ClientStatus {
    private ClientData clientData;
    private List<ClientCard> cards = new ArrayList<>();

    public ClientStatus() {
    }

    public ClientStatus(ClientData clientData, List<ClientCard> cards) {
        this.clientData = clientData;
        this.cards = cards;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public List<ClientCard> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    public void setCards(List<ClientCard> cards) {
        this.cards = cards;
    }
}
