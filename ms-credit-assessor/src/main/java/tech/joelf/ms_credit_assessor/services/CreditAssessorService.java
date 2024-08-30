package tech.joelf.ms_credit_assessor.services;

import org.springframework.stereotype.Service;

import tech.joelf.ms_credit_assessor.dtos.ClientStatus;
import tech.joelf.ms_credit_assessor.resources.ClientResource;

@Service
public class CreditAssessorService {

    private final ClientResource clientResource;

    public CreditAssessorService(ClientResource clientResource) {
        this.clientResource = clientResource;
    }

    public ClientStatus getClientStatus(String cpf) {
        var client = clientResource.findByCpf(cpf).getBody();
        return new ClientStatus(client, null);
    }
}
