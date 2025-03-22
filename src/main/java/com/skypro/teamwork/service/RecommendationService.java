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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class RecommendationService {
    @Autowired
    private RecommendationsDataSourceConfiguration dataSourceConfiguration;
    @Autowired
     List<RecommendationRuleSet> ruleSets;
    @Autowired
    RecommendationRuleSetInvest invest;
    @Autowired
    RecommendationRulSetCredit credit;
    @Autowired
    RecommendationRulSetSaving saving;


    public final RecommendationsRepository repository;



    public RecommendationService(RecommendationsRepository repository) {
        this.repository = repository;


    }
    public String getRecommendation(UUID id) {
        User user=null;

            if (repository.getRandomTransactionAmount(id)!=null
            &&repository.getSumAmountSaving(id)>1000) {
                 user=invest.getRecommendations(id);

            }
             if
            (repository.getDebit(id)!=null
                    &&repository.getSumAmountDebit(id)>=50000||repository.getSumAmountSaving(id)>=50000
            &&repository.getSumAmountDebit(id)>=repository.getSumAmountWithdraw(id)) {
                user=saving.getRecommendations(id);

            }
            if (repository.getNotCredit(id)!=null
                    &&repository.getSumAmountDebit(id)>=repository.getSumAmountWithdraw(id)
                    &&repository.getSumAmountWithdraw(id)>100000) {
                user=credit.getRecommendations(id);

            }




        return "user id:"+id+"\nRecommendation:"+user;

    }



}
