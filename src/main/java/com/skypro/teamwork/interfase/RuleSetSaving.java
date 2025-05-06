package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RuleSetSaving implements RuleSet{
    private final RecommendationsRepository repository;
    private final Recommendations recommendations;
    private final RequestsSet requestsSet;
    private final Type type;

    public RuleSetSaving(Recommendations recommendations,
                         RecommendationsRepository repository, Type type, RequestsSet requestsSet) {
        this.recommendations = recommendations;
        this.repository = repository;
        this.type = type;
        this.requestsSet = requestsSet;
    }
    @Override
    public Optional<Recommendations> recommendationsSet(UUID id) {
        Recommendations recommendations=new Recommendations(id,"Top saving","Откройте свою собственную «Копилку» с нашим банком! «Копилка» — это уникальный банковский инструмент, который поможет вам легко и удобно накапливать деньги на важные цели. Больше никаких забытых чеков и потерянных квитанций — всё под контролем!\n" +
                "\n" +
                "Преимущества «Копилки»:\n" +
                "\n" +
                "Накопление средств на конкретные цели. Установите лимит и срок накопления, и банк будет автоматически переводить определенную сумму на ваш счет.\n" +
                "\n" +
                "Прозрачность и контроль. Отслеживайте свои доходы и расходы, контролируйте процесс накопления и корректируйте стратегию при необходимости.\n" +
                "\n" +
                "Безопасность и надежность. Ваши средства находятся под защитой банка, а доступ к ним возможен только через мобильное приложение или интернет-банкинг.\n" +
                "\n" +
                "Начните использовать «Копилку» уже сегодня и станьте ближе к своим финансовым целям!",
                List.of((Requests) requestsSet.getRequestsUserOf(id,List.of(String.valueOf(Type.DEBIT))),
                        (Requests) requestsSet.getRequestsSum(id,List.of(String.valueOf(Type.SAVING),
                                String.valueOf(Type.DEBIT),">","50000")),
                        (Requests) requestsSet.getRequestsTransactionsSumCompareDepositWithdraw(id,
                                List.of(String.valueOf(Type.DEBIT),">"))));

        return Optional.empty();
    }
}
