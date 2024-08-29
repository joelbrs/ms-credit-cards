package tech.joelf.ms_clients.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tech.joelf.ms_clients.dtos.CreateClientRequest;
import tech.joelf.ms_clients.models.Client;
import tech.joelf.ms_clients.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Client> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clientService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateClientRequest client) {
        Client savedClient = clientService.create(client);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}")
                .buildAndExpand(savedClient.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Ok");
    }
}
