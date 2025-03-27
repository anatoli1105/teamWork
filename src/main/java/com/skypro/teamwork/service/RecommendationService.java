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


    private final List<RecommendationRuleSet> ruleSets;


    public final RecommendationsRepository repository;


    public RecommendationService(List<RecommendationRuleSet> ruleSets, RecommendationsRepository repository) {
        this.ruleSets = ruleSets;
        this.repository = repository;


    }

    public String getRecommendation(UUID id) {
        String user = null;


        //for (RecommendationRuleSet ruleSet : ruleSets) {
        //if (ruleSet.getRecommendations(id) != null)
        //user = ruleSet.getRecommendations(id).toString();

        //  }
        return ruleSets.stream().map(rule -> rule.getRecommendations(id)).filter(Optional::isPresent).map(Optional::get).toList().toString();
    }

    // return "user id:" + id + "\nRecommendation:" + user;


}

