package com.skypro.teamwork.service;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.interfase.RequestsSet;
import com.skypro.teamwork.model.RecommendationDTO;
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


    private final List<RecommendationRuleSet> ruleSets;

    private final RequestRepository requestRepository;

    private final RequestsSet requestsSet;
    public final RecommendationsRepository repository;


    public RecommendationService(List<RecommendationRuleSet> ruleSets, RecommendationsRepository repository,
                                 RequestRepository requestRepository,RequestsSet requestsSet) {
        this.ruleSets = ruleSets;
        this.repository = repository;
        this.requestRepository = requestRepository;
        this.requestsSet = requestsSet;


    }

    public List<RecommendationDTO> getRecommendation(UUID id) {


        return ruleSets.stream().
                map(rule -> rule.
                        getRecommendations(id)).
                filter(Optional::isPresent).
                map(Optional::get).toList();
    }

    public List<Requests> addRule(UUID id, List<String> listArgument) {

        List<Requests> save = requestRepository.save(requestsSet.getRequests(id, listArgument));
        return save;
         }



    }

