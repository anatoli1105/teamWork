package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Request;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component(value = "investRequest")
public class RuleSetInvest implements RuleSet {


    private final RecommendationsRepository repository;
    private final RequestsSet requestsSet;


    public RuleSetInvest(RecommendationsRepository repository, RequestsSet requestsSet) {
        this.repository = repository;
        this.requestsSet = requestsSet;
    }


    @Override
    public Optional<Recommendations> recommendationsSet(UUID id) {
        Recommendations recommendations1 = null;
        if (requestsSet.getRequestsUserOf(id, List.of("DEBIT"), new Recommendations()).getNegate() == true &&
                requestsSet.getRequestsActiveUserOf(id, List.of("INVEST"), new Recommendations()).getNegate() == true &&
                requestsSet.getRequestsSum(id, List.of("SAVING",
                        "DEPOSIT", ">", "1000"), new Recommendations()).getNegate() == true) {

            recommendations1 = new Recommendations(id, "invest", repository.seachProductId(id), "Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС)" +
                    " от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом." +
                    " Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде." +
                    " Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. " +
                    "Откройте ИИС сегодня и станьте ближе к финансовой независимости!",
                    List.of(requestsSet.getRequestsUserOf(id, List.of("DEBIT"), new Recommendations()),
                            requestsSet.getRequestsActiveUserOf(id, List.of("INVEST"), new Recommendations()),
                            requestsSet.getRequestsSum(id, List.of("SAVING",
                                    "DEPOSIT", ">", "1000"), new Recommendations())));
        }

        return Optional.ofNullable(recommendations1);
    }
}

