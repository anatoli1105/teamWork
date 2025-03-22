package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component(value = "credit")
public class RecommendationRulSetCredit extends RecommendationRuleSet {
    public User getRecommendations(UUID id){
        if(id!=null){
            return new User(id,"credit","text");
        }else {
            return null;
        }
    }
}
