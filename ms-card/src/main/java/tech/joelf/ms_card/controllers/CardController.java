package tech.joelf.ms_card.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tech.joelf.ms_card.dtos.ClientCardResponse;
import tech.joelf.ms_card.dtos.CreateCardRequest;
import tech.joelf.ms_card.models.Card;
import tech.joelf.ms_card.services.CardService;
import tech.joelf.ms_card.services.ClientCardService;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    public CardController(CardService cardService, ClientCardService clientCardService) {
        this.cardService = cardService;
        this.clientCardService = clientCardService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateCardRequest request) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cardService.create(request).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardLessThanEqual(@RequestParam("income") Long income) {
        return ResponseEntity.ok(cardService.getCardsLessThanEqual(income));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardResponse>> findByCpf(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok(clientCardService.findByCpf(cpf));
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Ok");
    }
}
