package com.skypro.teamwork.service;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.interfase.RuleSet;
import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.repository.RecommendationRepository;
import com.skypro.teamwork.repository.RecommendationsRepository;
import com.skypro.teamwork.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class RecommendationService {

@Autowired
private  List<RecommendationRuleSet> recommendationRuleSets;
@Autowired
private List<RuleSet>ruleSets;




private final RecommendationRepository repository;
private final RequestRepository requestRepository;

    public RecommendationService(RecommendationRepository repository,RequestRepository requestRepository) {
        this.repository = repository;
        this.requestRepository=requestRepository;
    }






    public List<RecommendationDTO> getRecommendation(UUID id) {


        return recommendationRuleSets.stream().
                map(rule -> rule.getRecommendations
                        (id)).
                filter(Optional::isPresent).
                map(Optional::get).toList();
    }

   public List< Recommendations> addRule(UUID id) {

      var add= ruleSets.stream().
               map(rule -> rule.recommendationsSet
                       (id)).
               filter(Optional::isPresent).
               map(Optional::get).toList();
       for (Recommendations recommendations : add) {
           var set=repository.save(recommendations);


       }

        return add;

         
         


        }



        public List<Recommendations> getAll(){
        return repository.findAll();
        }



    }

