package tech.joelf.ms_card.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.joelf.ms_card.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT c FROM Card c WHERE c.income <= :income")
    List<Card> findByIncomeLessThanEqual(Long income);
}
