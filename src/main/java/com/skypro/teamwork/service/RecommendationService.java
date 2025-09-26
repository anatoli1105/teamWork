package com.skypro.teamwork.service;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.interfase.RuleSet;
import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Request;
import com.skypro.teamwork.model.Stats;
import com.skypro.teamwork.repository.RecommendationRepository;
import com.skypro.teamwork.repository.RecommendationsRepository;
import com.skypro.teamwork.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class RecommendationService {
    private final RecommendationsRepository recommendationsRepository;

    private final List<RecommendationRuleSet> recommendationRuleSets;
    private final RecommendationRepository repository;
    private final RequestRepository requestRepository;
    private final List<RuleSet> ruleSets;

    public RecommendationService(RecommendationRepository repository, RequestRepository requestRepository,
                                 List<RuleSet> ruleSets, List<RecommendationRuleSet> recommendationRuleSets,
                                 RecommendationsRepository recommendationsRepository) {
        this.repository = repository;
        this.requestRepository = requestRepository;
        this.ruleSets = ruleSets;
        this.recommendationRuleSets = recommendationRuleSets;
        this.recommendationsRepository = recommendationsRepository;
    }


    public List<RecommendationDTO> getRecommendation(UUID id) {


        return recommendationRuleSets.stream().
                map(rule -> rule.getRecommendations
                        (id)).
                filter(Optional::isPresent).
                map(Optional::get).toList();
    }

    public List<Recommendations> addRule(UUID id) {
        Request requests = null;
        List<Recommendations> getRule = ruleSets.stream().
                map(rule -> rule.recommendationsSet
                        (id)).
                filter(Optional::isPresent).
                map(Optional::get).toList();
        for (Recommendations recommendations : getRule) {
            Recommendations addRecommendation = repository.save(recommendations);

        }


        return getRule;


    }

    public List<Recommendations> getAll() {
        return repository.findAll();
    }

    public List<Request> all() {
        return requestRepository.findAll();
    }

    public void deleteRule(UUID id) {
        if (repository.findByRecomendations(id).getUseId() != null) {
            repository.delete(repository.findByRecomendations(id));
        }


    }

    @Cacheable//(cacheNames = "RecommendationsCache", unless = "#result == null")
            (value = "Recommendations", cacheManager = "cacheManager", key = "#id")
    public List<Recommendations> getName(UUID id) {
        return addRule(id);



    }

    public UUID searchUserId(String firstName, String lastName) {
        return recommendationsRepository.searchId(firstName, lastName);
    }

    public List<Recommendations> addRuleForName(String firstName, String lastName) {
        Request requests = null;
        List<Recommendations> getRule = ruleSets.stream().
                map(rule -> rule.recommendationsSet
                        (recommendationsRepository.searchId(firstName, lastName))).
                filter(Optional::isPresent).
                map(Optional::get).toList();
        for (Recommendations recommendations : getRule) {
            Recommendations addRecommendation = repository.save(recommendations);

        }


        return getRule;


    }

    public boolean searchUserName(String firstName, String lastName) {
        return recommendationsRepository.searchName(firstName, lastName);
    }

    public String newNegate(Boolean negate) {
        String temp = null;
        if (negate == true) {
            temp = "true";
        } else {
            temp = "false";
        }
        return temp;
    }

    public List<Stats> countRule() {
        List<Stats> stats = List.of(new Stats(repository.findByProductId("invest"), repository.findBySum("invest")),
                new Stats(repository.findByProductId("credit"), repository.findBySum("credit")),
                new Stats(repository.findByProductId("Top saving"), repository.findBySum("Top saving")));
        return stats;


    }


}

