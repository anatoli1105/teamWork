package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Request;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RuleSetSaving extends RuleSet {

    private final RecommendationsRepository repository;
    private final RequestsSet requestsSet;


    public RuleSetSaving(RecommendationsRepository repository, RequestsSet requestsSet) {

        this.repository = repository;
        this.requestsSet = requestsSet;
    }

    @Override
    public Optional<Recommendations> recommendationsSet(UUID id) {
        Recommendations recommendations = null;
        if (requestsSet.getRequestsUserOf(id, List.of(Type.DEBIT.name()), new Recommendations()).getNegate() == true &&
                requestsSet.getRequestsSum(id, List.of(Type.DEBIT.name(),
                        Type.DEPOSIT.name(), ">=", "50000"), new Recommendations()).getNegate() == true &&
                requestsSet.getRequestsTransactionsSumCompareDepositWithdraw(id,
                        List.of(Type.DEBIT.name(), ">"), new Recommendations()).getNegate() == true) {
            recommendations = new Recommendations(id, "Top saving", repository.seachProductId(id), "Откройте свою собственную «Копилку» с нашим банком! «Копилка» — это уникальный банковский инструмент, который поможет вам легко и удобно накапливать деньги на важные цели. Больше никаких забытых чеков и потерянных квитанций — всё под контролем!\n" +
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
                    List.of(requestsSet.getRequestsUserOf(id, List.of(Type.DEBIT.name()), new Recommendations()),
                            requestsSet.getRequestsSum(id, List.of(Type.DEBIT.name(),
                                    Type.DEPOSIT.name(), ">", "50000"), new Recommendations()),
                            requestsSet.getRequestsTransactionsSumCompareDepositWithdraw(id,
                                    List.of(Type.DEBIT.name(), ">"), new Recommendations())));
        }

        return Optional.ofNullable(recommendations);
    }
}
