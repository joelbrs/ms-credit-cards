package tech.joelf.ms_credit_assessor.resources;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tech.joelf.ms_credit_assessor.models.ClientCard;
import tech.joelf.ms_credit_assessor.models.CreditCard;

@FeignClient(value = "ms-card")
public interface CardResource {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> findByCpf(@RequestParam("cpf") String cpf);

    @GetMapping(params = "income")
    ResponseEntity<List<CreditCard>> getCardLessThanEqual(@RequestParam("income") Long income);
}
