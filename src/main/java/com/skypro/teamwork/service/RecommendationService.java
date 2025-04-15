package com.skypro.teamwork.service;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<RecommendationDTO> getRecommendation(UUID id) {




        return ruleSets.stream().map(rule -> rule.getRecommendations(id)).filter(Optional::isPresent).map(Optional::get).toList();
    }
    //public addRule()
   // public deleteRule()
    //public getAllRule()




}

