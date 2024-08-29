package tech.joelf.ms_card.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tech.joelf.ms_card.dtos.ClientCardResponse;
import tech.joelf.ms_card.repositories.ClientCardRepository;

@Service
public class ClientCardService {

    private final ClientCardRepository clientCardRepository;

    public ClientCardService(ClientCardRepository clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    public List<ClientCardResponse> findByCpf(String cpf) {
        return clientCardRepository.findByCpf(cpf).stream().map(ClientCardResponse::fromModel)
                .collect(Collectors.toList());
    }
}
