package tech.joelf.ms_credit_assessor.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tech.joelf.ms_credit_assessor.models.ClientData;

@FeignClient(value = "ms-clients")
public interface ClientResource {

    @GetMapping("/{cpf}")
    ResponseEntity<ClientData> findByCpf(@PathVariable String cpf);
}
