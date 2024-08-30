package tech.joelf.ms_credit_assessor.models;

import java.math.BigDecimal;

public class EmissionCardData {
    private Long idCard;
    private String cpf;
    private String address;
    private BigDecimal liberatedLimit;

    public EmissionCardData() {
    }

    public EmissionCardData(Long idCard, String cpf, String address, BigDecimal liberatedLimit) {
        this.idCard = idCard;
        this.cpf = cpf;
        this.address = address;
        this.liberatedLimit = liberatedLimit;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLiberatedLimit() {
        return liberatedLimit;
    }

    public void setLiberatedLimit(BigDecimal liberatedLimit) {
        this.liberatedLimit = liberatedLimit;
    }
}
