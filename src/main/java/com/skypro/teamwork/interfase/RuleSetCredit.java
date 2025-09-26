package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Request;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component(value = "CreditRequest")
public class RuleSetCredit implements RuleSet {

   private final RecommendationsRepository repository;
    private final RequestsSet requestsSet;

    public RuleSetCredit(
            RecommendationsRepository repository, RequestsSet requestsSet) {
        this.repository = repository;
        this.requestsSet = requestsSet;

    }
    @Override
    public Optional<Recommendations> recommendationsSet(UUID id) {
        Recommendations recommendations = null;
        if (requestsSet.getRequestsActiveUserOf(id, List.of(Type.CREDIT.name()), new Recommendations()).getNegate() == true
                && requestsSet.getRequestsTransactionsSumCompareDepositWithdraw(id,
                List.of(Type.DEBIT.name(), ">"), new Recommendations()).getNegate() == true
                && requestsSet.getRequestsSum(id, List.of(Type.DEBIT.name(),
                Type.WITHDRAW.name(), ">", "100000"), new Recommendations()).getNegate() == true) {

            recommendations = new Recommendations(id, "credit", repository.searchProductId(id), "Откройте мир выгодных кредитов с нами!\n" +
                    "Ищете способ быстро и без лишних хлопот получить нужную сумму? Тогда наш выгодный кредит — именно то, " +
                    "что вам нужно! Мы предлагаем низкие процентные ставки, гибкие условия и индивидуальный подход к каждому клиенту." +
                    "Почему выбирают нас:\n" +
                    "Быстрое рассмотрение заявки. Мы ценим ваше время, поэтому процесс рассмотрения заявки занимает всего несколько часов.\n" +
                    "Удобное оформление. Подать заявку на кредит можно онлайн на нашем сайте или в мобильном приложении.\n" +
                    "Широкий выбор кредитных продуктов. Мы предлагаем кредиты на различные цели: покупку недвижимости, " +
                    "автомобиля, образование, лечение и многое другое.\n" +
                    "Не упустите возможность воспользоваться выгодными условиями кредитования от нашей компании!",
                    List.of((requestsSet.getRequestsActiveUserOf(id, List.of("CREDIT"), new Recommendations())),
                            (requestsSet.getRequestsTransactionsSumCompareDepositWithdraw(id,
                                    List.of(Type.DEBIT.name(), ">"), new Recommendations())),
                            (requestsSet.getRequestsSum(id, List.of(Type.DEBIT.name(),
                                    "WITHDRAW", ">", "100000"), new Recommendations()))));
        }
        return Optional.ofNullable(recommendations);


    }
}
