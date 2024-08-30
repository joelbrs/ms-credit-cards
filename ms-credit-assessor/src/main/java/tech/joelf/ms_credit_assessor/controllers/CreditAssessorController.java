package tech.joelf.ms_credit_assessor.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.joelf.ms_credit_assessor.dtos.ClientStatus;
import tech.joelf.ms_credit_assessor.services.CreditAssessorService;

@RestController
@RequestMapping("/credit-assessor")
public class CreditAssessorController {

    private final CreditAssessorService creditAssessorService;

    public CreditAssessorController(CreditAssessorService creditAssessorService) {
        this.creditAssessorService = creditAssessorService;
    }

    @GetMapping("client-status")
    public ResponseEntity<ClientStatus> getClientStatus(@RequestParam String cpf) {
        return ResponseEntity.ok(creditAssessorService.getClientStatus(cpf));
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Ok");
    }
}
