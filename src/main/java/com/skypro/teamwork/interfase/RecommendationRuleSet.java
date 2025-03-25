package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.User;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecommendationRuleSet   {
    public  User getRecommendations(UUID id );


}


