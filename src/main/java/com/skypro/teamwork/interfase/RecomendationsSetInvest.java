package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;

import java.util.List;
import java.util.UUID;

public class RecomendationsSetInvest implements RuleSet{
    private final RecommendationsRepository repository;
    private final RecommendationDTO recommendationDTO;
    private final RequestsSet requestsSet;
    private final Type type;

    public RecomendationsSetInvest(RecommendationDTO recommendationDTO,
                                   RecommendationsRepository repository, Type type, RequestsSet requestsSet) {
        this.recommendationDTO = recommendationDTO;
        this.repository = repository;
        this.type = type;
        this.requestsSet = requestsSet;
    }




    @Override
    public Recommendations recommendationsSet(UUID id) {


            Recommendations recommendation = new Recommendations(id, "invest", "Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС)" +
                    " от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом." +
                    " Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде." +
                    " Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. " +
                    "Откройте ИИС сегодня и станьте ближе к финансовой независимости!",
                    List.of((Requests) requestsSet.getRequestsUserOf(id,List.of(String.valueOf(Type.DEBIT))),
                            (Requests) requestsSet.getRequestsActiveUserOf(id,List.of(String.valueOf(Type.INVEST))),
                            (Requests) requestsSet.getRequestsSum(id,List.of(String.valueOf(Type.SAVING),">","1000"))));

        return recommendation;
    }
}
