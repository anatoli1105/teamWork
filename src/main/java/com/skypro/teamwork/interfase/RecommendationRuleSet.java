package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.RecommendationDTO;

import java.util.Optional;
import java.util.UUID;

public interface RecommendationRuleSet {




    public Optional<RecommendationDTO> getRecommendations(UUID id );


}


