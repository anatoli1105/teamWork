package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.User;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component(value = "invest")
public class RecommendationRuleSetInvest extends RecommendationRuleSet  {
@Override
public  User getRecommendations(UUID id){
    if(id!=null){
        return new User(id,"invest","text");
    }else {
        return null;
    }
}


}
