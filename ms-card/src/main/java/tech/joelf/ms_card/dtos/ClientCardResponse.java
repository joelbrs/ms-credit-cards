package tech.joelf.ms_card.dtos;

import java.math.BigDecimal;

import tech.joelf.ms_card.models.ClientCard;

public class ClientCardResponse {
    private String name;
    private String flag;
    private BigDecimal limitLiberated;

    public static ClientCardResponse fromModel(ClientCard card) {
        ClientCardResponse response = new ClientCardResponse();
        response.name = card.getCard().getName();
        response.flag = card.getCard().getFlag().toString();
        response.limitLiberated = card.getLimit();
        return response;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public BigDecimal getLimitLiberated() {
        return limitLiberated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setLimitLiberated(BigDecimal limitLiberated) {
        this.limitLiberated = limitLiberated;
    }
}
