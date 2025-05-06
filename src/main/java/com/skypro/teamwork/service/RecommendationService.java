package com.skypro.teamwork.service;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.interfase.RequestsSet;
import com.skypro.teamwork.interfase.RuleSet;
import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.repository.RecommendationsRepository;
import com.skypro.teamwork.repository.RequestRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestScope;

import java.util.*;

@Service

public class RecommendationService {
@Autowired
List<RuleSet> ruleSet;

    private final RequestRepository requestRepository;

   private final List<RecommendationRuleSet> recommendationsDto;
private final Recommendations recommendations;

    public final RecommendationsRepository repository;


    public RecommendationService( RecommendationsRepository repository,List<RecommendationRuleSet> recommendationsDto,
                                 RequestRepository requestRepository,Recommendations recommendations) {

        this.repository = repository;
        this.requestRepository = requestRepository;
        this.recommendationsDto=recommendationsDto;
        this.recommendations=recommendations;



    }

    public List<RecommendationDTO> getRecommendation(UUID id) {


        return recommendationsDto.stream().
                map(rule -> rule.
                        (id)).
                filter(Optional::isPresent).
                map(Optional::get).toList();
    }

    public List<Recommendations> addRule(UUID id) {

        for (RuleSet set : ruleSet) {
            if(set.recommendationsSet(id).g)
        }

        }



    }

