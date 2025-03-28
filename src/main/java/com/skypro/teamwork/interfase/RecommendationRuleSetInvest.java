package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component(value = "invest")
public class RecommendationRuleSetInvest implements RecommendationRuleSet  {
    private final RecommendationsRepository repository;
    private final RecommendationDTO recommendationDTO;

    public RecommendationRuleSetInvest(RecommendationsRepository repository, RecommendationDTO recommendationDTO) {
        this.repository = repository;
        this.recommendationDTO = recommendationDTO;
    }

    @Override
public Optional<RecommendationDTO> getRecommendations(UUID id) {

    String typeProductDebit = "DEBIT";
    String typeProductInvest = "INVEST";
    String typeProductCredit = "CREDIT";
    String typeProductSaving = "SAVING";
    String typeTransactionDeposit = "DEPOSIT";
    String typeTransactionWithdraw = "WITHDRAW";
    Optional<RecommendationDTO>recomendations =Optional.empty();



    if (repository.userOf(id, typeProductDebit) == true &&
            repository.userOf(id, typeProductInvest) != true &&
            repository.sum(id, typeProductSaving, typeTransactionDeposit) > 1000) {

       RecommendationDTO recomendation = new RecommendationDTO(id, "invest", "Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС)" +
                " от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом." +
                " Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде." +
                " Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. " +
                "Откройте ИИС сегодня и станьте ближе к финансовой независимости!");
    }
    return Optional.of(recommendationDTO);

}



}
