package tech.joelf.ms_credit_assessor.services;

import org.springframework.stereotype.Service;

import tech.joelf.ms_credit_assessor.dtos.ClientStatus;
import tech.joelf.ms_credit_assessor.resources.CardResource;
import tech.joelf.ms_credit_assessor.resources.ClientResource;

@Service
public class CreditAssessorService {

    private final ClientResource clientResource;
    private final CardResource cardResource;

    public CreditAssessorService(ClientResource clientResource, CardResource cardResource) {
        this.clientResource = clientResource;
        this.cardResource = cardResource;
    }

    public ClientStatus getClientStatus(String cpf) {
        var client = clientResource.findByCpf(cpf).getBody();
        var cards = cardResource.findByCpf(cpf).getBody();
        return new ClientStatus(client, cards);
    }
}
