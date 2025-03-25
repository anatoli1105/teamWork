package com.skypro.teamwork.service;

import com.skypro.teamwork.configuration.RecommendationsDataSourceConfiguration;
import com.skypro.teamwork.interfase.RecommendationRulSetCredit;
import com.skypro.teamwork.interfase.RecommendationRulSetSaving;
import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.interfase.RecommendationRuleSetInvest;
import com.skypro.teamwork.model.User;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class RecommendationService {
    @Autowired
    private RecommendationsDataSourceConfiguration dataSourceConfiguration;
    @Autowired
    List<RecommendationRuleSet> ruleSets;



    public final RecommendationsRepository repository;



    public RecommendationService(RecommendationsRepository repository) {
        this.repository = repository;


    }
    public String getRecommendation(UUID id) {
        User user=null;
        String typeProductDebit="DEBIT";
        String typeProductInvest="INVEST";
        String typeProductCredit="CREDIT";
        String typeProductSaving="SAVING";
        String typeTransactionDeposit="DEPOSIT";
        String typeTransactionWithdraw="WITHDRAW";



            if (repository.userOf(id, typeProductDebit) ==true &&
                    //repository.userOf(id,typeProductInvest)==false&&
                    repository.sum(id, typeProductSaving, typeTransactionDeposit) > 1000) {
                user = (User) ruleSets.get(0).getRecommendations(id);

            }
          /*   if
            (
                    repository.userOf(id,typeProductDebit)!=null&&
             repository.sum(id,typeProductDebit,typeTransactionDeposit)>=50000||
             repository.sum(id,typeProductSaving,typeTransactionDeposit)>=50000&&
             repository.sum(id,typeProductDebit,typeTransactionDeposit)>
             repository.sum(id,typeProductDebit,typeTransactionWithdraw)) {
                user=saving.getRecommendations(id);

            }
            if (repository.userOf(id,typeProductCredit)==null&&
                    repository.sum(id,typeProductDebit,typeTransactionDeposit)>
                            repository.sum(id,typeProductDebit,typeTransactionWithdraw)&&
                    repository.sum(id,typeProductDebit,typeTransactionWithdraw)>100000
                    ) {
                user=credit.getRecommendations(id);

            }*/





        return "user id:"+id+"\nRecommendation:"+user;

    }



}

