package com.skypro.teamwork.service;

import com.skypro.teamwork.configuration.RecommendationsDataSourceConfiguration;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class RecommendationService {
    @Autowired
    private RecommendationsDataSourceConfiguration dataSourceConfiguration;


    public final RecommendationsRepository repository;

    public RecommendationService(RecommendationsRepository repository) {
        this.repository = repository;
    }
    public int getСonditions(UUID id) {
        if(id!=null) {
            return repository.getRandomTransactionAmount(id);
        }else {
            return (Integer)null;
        }

    }
    public JdbcTemplate getAll(){

        return repository.getAll();
    }


}
