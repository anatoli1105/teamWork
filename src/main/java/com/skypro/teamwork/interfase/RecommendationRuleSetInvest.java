package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.User;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component(value = "invest")
public class RecommendationRuleSetInvest implements RecommendationRuleSet  {
@Override
public  User getRecommendations(UUID id){
    if(id!=null){
        return new User(id,"invest","Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС)" +
                " от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом." +
                " Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде." +
                " Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. " +
                "Откройте ИИС сегодня и станьте ближе к финансовой независимости!");
    }else {
        return null;
    }
}



}
