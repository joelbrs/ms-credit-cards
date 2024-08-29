package tech.joelf.ms_clients.dtos;

import tech.joelf.ms_clients.models.Client;

public class CreateClientRequest {
    private String cpf;
    private String name;
    private Integer age;

    public CreateClientRequest() {
    }

    public Client toModel() {
        return new Client(null, cpf, name, age);
    }
}
