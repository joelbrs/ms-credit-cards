package tech.joelf.ms_credit_assessor.models;

public class ProtocolSolicitationCard {
    private String protocol;

    public ProtocolSolicitationCard() {
    }

    public ProtocolSolicitationCard(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
