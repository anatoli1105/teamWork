package com.skypro.teamwork.repository;

import com.skypro.teamwork.model.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendations,Long> {
}
