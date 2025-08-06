package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component(value = "invest")


public class RecommendationRuleSetInvest implements RecommendationRuleSet {

    private final RecommendationsRepository repository;

    public RecommendationRuleSetInvest(RecommendationsRepository repository) {
        this.repository = repository;


    }
    @Override


    public Optional<RecommendationDTO> getRecommendations(UUID id) {
        RecommendationDTO recommendationDTO = null;
        if (repository.userOf(id, Type.DEBIT.name()) == true &&
                repository.userOf(id, Type.CREDIT.name()) != true &&
                repository.sum(id, Type.SAVING.name(), Type.DEPOSIT.name()) > 1000) {

            recommendationDTO = new RecommendationDTO(id, "invest", "Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС)" +
                    " от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом." +
                    " Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде." +
                    " Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. " +
                    "Откройте ИИС сегодня и станьте ближе к финансовой независимости!");
        }


        return Optional.of(recommendationDTO);

    }


}
