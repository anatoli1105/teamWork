package com.skypro.teamwork.service;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.interfase.RuleSet;
import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.repository.RecommendationsRepository;
import com.skypro.teamwork.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class RecommendationService {
//@Autowired
//List<RuleSet> ruleSet;
@Autowired
private  List<RecommendationRuleSet> recommendationRuleSets;


private final RecommendationDTO recommendations;

   //public final RecommendationsRepository repository;
   // private final RequestRepository requestRepository;

    public RecommendationService( //RecommendationsRepository repository,
                                 //RequestRepository requestRepository,
                                  RecommendationDTO recommendations) {

       // this.repository = repository;
        //this.requestRepository = requestRepository;
        this.recommendations=recommendations;



    }

    public List<RecommendationDTO> getRecommendation(UUID id) {


        return recommendationRuleSets.stream().
                map(rule -> rule.getRecommendations
                        (id)).
                filter(Optional::isPresent).
                map(Optional::get).toList();
    }

   /* public List<Recommendations> addRule(UUID id) {

        return ruleSet.stream().
                map(rule -> rule.recommendationsSet
                        (id)).
                filter(Optional::isPresent).
                map(Optional::get).toList();

        }*/



    }

