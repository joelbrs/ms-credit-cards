package tech.joelf.ms_clients.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.joelf.ms_clients.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.cpf = :cpf")
    Optional<Client> findByCpf(String cpf);
}
