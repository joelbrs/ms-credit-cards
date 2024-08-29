package tech.joelf.ms_card.dtos;

import java.math.BigDecimal;

import tech.joelf.ms_card.enums.FlagCard;
import tech.joelf.ms_card.models.Card;

public class CreateCardRequest {
    private String name;
    private FlagCard flag;
    private BigDecimal income;
    private BigDecimal limit;

    public CreateCardRequest() {
    }

    public Card toModel() {
        return new Card(null, name, flag, limit, income);
    }
}
