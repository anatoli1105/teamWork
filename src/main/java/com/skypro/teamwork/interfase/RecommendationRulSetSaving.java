package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component(value = "saving")
public class RecommendationRulSetSaving extends RecommendationRuleSet{
    @Override
    public User getRecommendations(UUID id){
        if(id!=null){
            return new User(id,"Top saving","text");
        }else {
            return null;
        }
    }
}
