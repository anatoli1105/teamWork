package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component(value = "saving")
public class RecommendationRulSetSaving implements RecommendationRuleSet{
    private final RecommendationsRepository repository;
    private final RecommendationDTO recommendationDTO;

    public RecommendationRulSetSaving(RecommendationsRepository repository, RecommendationDTO recommendationDTO) {
        this.repository = repository;
        this.recommendationDTO = recommendationDTO;
    }

    @Override

    public Optional<RecommendationDTO> getRecommendations(UUID id){
       String typeProductDebit = "DEBIT";
       String typeProductInvest = "INVEST";
       String typeProductCredit = "CREDIT";
       String typeProductSaving = "SAVING";
       String typeTransactionDeposit = "DEPOSIT";
       String typeTransactionWithdraw = "WITHDRAW";

        if(       repository.userOf(id, Type.DEBIT.toString())==true&&

                repository.sum(id,typeProductDebit,typeTransactionDeposit)>=50000||
               repository.sum(id,typeProductSaving,typeTransactionDeposit)>=50000&&
                       repository.sum(id,typeProductDebit,typeTransactionDeposit)>
                                repository.sum(id,typeProductDebit,typeTransactionWithdraw)){
         RecommendationDTO recommendationDTO1=new RecommendationDTO(id,"Top saving","Откройте свою собственную «Копилку» с нашим банком! «Копилка» — это уникальный банковский инструмент, который поможет вам легко и удобно накапливать деньги на важные цели. Больше никаких забытых чеков и потерянных квитанций — всё под контролем!\n" +
                    "\n" +
                    "Преимущества «Копилки»:\n" +
                    "\n" +
                    "Накопление средств на конкретные цели. Установите лимит и срок накопления, и банк будет автоматически переводить определенную сумму на ваш счет.\n" +
                    "\n" +
                    "Прозрачность и контроль. Отслеживайте свои доходы и расходы, контролируйте процесс накопления и корректируйте стратегию при необходимости.\n" +
                    "\n" +
                    "Безопасность и надежность. Ваши средства находятся под защитой банка, а доступ к ним возможен только через мобильное приложение или интернет-банкинг.\n" +
                    "\n" +
                    "Начните использовать «Копилку» уже сегодня и станьте ближе к своим финансовым целям!");
        }

        return Optional.of(recommendationDTO) ;

    }
}
