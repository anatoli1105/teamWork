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
public class RuleSetCredit implements RuleSet {

    private final RecommendationsRepository repository;
    private  final Recommendations recommendations;
    private final RequestsSet requestsSet;
   // private final Request request;

    public RuleSetCredit(Recommendations recommendations,
                         RecommendationsRepository repository,  RequestsSet requestsSet){//,Request request) {
        this.recommendations=recommendations;
        this.repository = repository;
        //this.type = type;
        this.requestsSet = requestsSet;
       // this.request=request;
    }




    @Override
    public Optional<Recommendations> recommendationsSet(UUID id) {



            Recommendations recomendations = new Recommendations(id, "credit",repository.seachProductId(id), "Откройте мир выгодных кредитов с нами!\n" +
                    "Ищете способ быстро и без лишних хлопот получить нужную сумму? Тогда наш выгодный кредит — именно то, " +
                    "что вам нужно! Мы предлагаем низкие процентные ставки, гибкие условия и индивидуальный подход к каждому клиенту." +
                    "Почему выбирают нас:\n" +
                    "Быстрое рассмотрение заявки. Мы ценим ваше время, поэтому процесс рассмотрения заявки занимает всего несколько часов.\n" +
                    "Удобное оформление. Подать заявку на кредит можно онлайн на нашем сайте или в мобильном приложении.\n" +
                    "Широкий выбор кредитных продуктов. Мы предлагаем кредиты на различные цели: покупку недвижимости, " +
                    "автомобиля, образование, лечение и многое другое.\n" +
                    "Не упустите возможность воспользоваться выгодными условиями кредитования от нашей компании!",
                   List.of((Request) requestsSet.getRequestsUserOf(id,List.of("CREDIT")),
                            (Request) requestsSet.getRequestsTransactionsSumCompareDepositWithdraw(id,
                                    List.of("DEBIT",">")),
                            (Request) requestsSet.getRequestsSum(id,List.of("DEBIT",
                                    "WITHDRAW",">","100000"))));


        return Optional.of(recommendations);

    }
}
