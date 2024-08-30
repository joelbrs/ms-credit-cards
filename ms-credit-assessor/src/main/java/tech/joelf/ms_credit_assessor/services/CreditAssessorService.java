package tech.joelf.ms_credit_assessor.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tech.joelf.ms_credit_assessor.dtos.ClientAssessmentReturnResponse;
import tech.joelf.ms_credit_assessor.dtos.ClientStatus;
import tech.joelf.ms_credit_assessor.dtos.DataAssessmentRequest;
import tech.joelf.ms_credit_assessor.models.ApprovedCard;
import tech.joelf.ms_credit_assessor.resources.CardResource;
import tech.joelf.ms_credit_assessor.resources.ClientResource;

@Service
public class CreditAssessorService {

    private final ClientResource clientResource;
    private final CardResource cardResource;

    public CreditAssessorService(ClientResource clientResource, CardResource cardResource) {
        this.clientResource = clientResource;
        this.cardResource = cardResource;
    }

    public ClientStatus getClientStatus(String cpf) {
        var client = clientResource.findByCpf(cpf).getBody();
        var cards = cardResource.findByCpf(cpf).getBody();
        return new ClientStatus(client, cards);
    }

    public ClientAssessmentReturnResponse assessClient(DataAssessmentRequest request) {
        var client = clientResource.findByCpf(request.getCpf()).getBody();
        var cards = cardResource.getCardLessThanEqual(request.getIncome()).getBody();

        List<ApprovedCard> approvedCards = cards.stream().map(c -> {
            var approvedCard = new ApprovedCard(c.getName(), c.getFlag());
            approvedCard.calculateLimit(BigDecimal.valueOf(c.getLimitBasic()), BigDecimal.valueOf(client.getAge()),
                    BigDecimal.valueOf(request.getIncome()));

            return approvedCard;
        }).collect(Collectors.toList());

        return new ClientAssessmentReturnResponse(approvedCards);
    }
}
