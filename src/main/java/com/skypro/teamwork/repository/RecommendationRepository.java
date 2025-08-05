package com.skypro.teamwork.repository;

import com.skypro.teamwork.model.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.UUID;

public interface RecommendationRepository extends JpaRepository<Recommendations,Long>{
    @Query(value = "select * from recommendations r where  use_id=? limit 1", nativeQuery = true)
    Recommendations findByRecomendations(UUID id);

}
