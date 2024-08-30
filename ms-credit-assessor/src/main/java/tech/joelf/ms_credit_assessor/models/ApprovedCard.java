package tech.joelf.ms_credit_assessor.models;

import java.math.BigDecimal;

public class ApprovedCard {
    private String cardNumber;
    private String flag;
    private BigDecimal limit;

    public ApprovedCard(String cardNumber, String flag) {
        this.cardNumber = cardNumber;
        this.flag = flag;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getFlag() {
        return flag;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public void calculateLimit(BigDecimal basicLimit, BigDecimal age, BigDecimal income) {
        var factor = age.divide(BigDecimal.valueOf(10));

        this.limit = factor.multiply(basicLimit);
    }
}