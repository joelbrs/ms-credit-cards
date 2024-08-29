package tech.joelf.ms_card.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.joelf.ms_card.models.ClientCard;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    @Query("SELECT c FROM ClientCard c WHERE c.cpf = :cpf")
    List<ClientCard> findByCpf(String cpf);
}
