package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.User;
import com.skypro.teamwork.repository.RecommendationsRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component(value = "invest")
public class RecommendationRuleSetInvest implements RecommendationRuleSet  {
    private final RecommendationsRepository repository;

    public RecommendationRuleSetInvest(RecommendationsRepository repository) {
        this.repository = repository;
    }

    @Override
public Optional< User> getRecommendations(UUID id) {

    String typeProductDebit = "DEBIT";
    String typeProductInvest = "INVEST";
    String typeProductCredit = "CREDIT";
    String typeProductSaving = "SAVING";
    String typeTransactionDeposit = "DEPOSIT";
    String typeTransactionWithdraw = "WITHDRAW";
    Optional<User>recomendations =Optional.empty();


    if (repository.userOf(id, typeProductDebit) == true &&
            repository.userOf(id, typeProductInvest) != true &&
            repository.sum(id, typeProductSaving, typeTransactionDeposit) > 1000) {

        recomendations = Optional.of(new User(id, "invest", "Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС)" +
                " от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом." +
                " Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде." +
                " Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. " +
                "Откройте ИИС сегодня и станьте ближе к финансовой независимости!"));
    }
    return recomendations;

}



}
