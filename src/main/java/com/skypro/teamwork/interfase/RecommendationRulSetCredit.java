package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.User;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component(value = "credit")
public class RecommendationRulSetCredit implements RecommendationRuleSet {
    private final RecommendationsRepository repository;

    public RecommendationRulSetCredit(RecommendationsRepository repository) {
        this.repository = repository;
    }

    @Override

        public Optional<User> getRecommendations(UUID id) {

            String typeProductDebit = "DEBIT";
            String typeProductInvest = "INVEST";
            String typeProductCredit = "CREDIT";
            String typeProductSaving = "SAVING";
            String typeTransactionDeposit = "DEPOSIT";
            String typeTransactionWithdraw = "WITHDRAW";
            Optional<User>recomendations =Optional.empty();


            if (repository.userOf(id,typeProductCredit)==true&&
                repository.sum(id,typeProductDebit,typeTransactionDeposit)>
                       repository.sum(id,typeProductDebit,typeTransactionWithdraw)&&
                repository.sum(id,typeProductDebit,typeTransactionWithdraw)>100000) {

                recomendations = Optional.of(new User(id, "credit", "Откройте мир выгодных кредитов с нами!\n" +
                        "Ищете способ быстро и без лишних хлопот получить нужную сумму? Тогда наш выгодный кредит — именно то, " +
                        "что вам нужно! Мы предлагаем низкие процентные ставки, гибкие условия и индивидуальный подход к каждому клиенту." +
                        "Почему выбирают нас:\n" +
                        "Быстрое рассмотрение заявки. Мы ценим ваше время, поэтому процесс рассмотрения заявки занимает всего несколько часов.\n" +
                        "Удобное оформление. Подать заявку на кредит можно онлайн на нашем сайте или в мобильном приложении.\n" +
                        "Широкий выбор кредитных продуктов. Мы предлагаем кредиты на различные цели: покупку недвижимости, " +
                        "автомобиля, образование, лечение и многое другое.\n" +
                        "Не упустите возможность воспользоваться выгодными условиями кредитования от нашей компании!"));
            }

                return recomendations;

            }
}
