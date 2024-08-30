package tech.joelf.ms_credit_assessor.models;

import java.math.BigDecimal;

public class ClientCard {
    private String name;
    private String flag;
    private BigDecimal limitLiberated;

    public ClientCard() {
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
