package tech.joelf.ms_clients.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.joelf.ms_clients.dtos.CreateClientRequest;
import tech.joelf.ms_clients.models.Client;
import tech.joelf.ms_clients.repositories.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client create(CreateClientRequest client) {
        return clientRepository.save(client.toModel());
    }

    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf).orElseThrow(RuntimeException::new);
    }
}
