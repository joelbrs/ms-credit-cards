package tech.joelf.ms_credit_assessor.services;

import org.springframework.stereotype.Service;

import tech.joelf.ms_credit_assessor.dtos.ClientStatus;

@Service
public class CreditAssessorService {

    public ClientStatus getClientStatus(String cpf) {
        return new ClientStatus();
    }
}
