package com.skypro.teamwork.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public class RecommendationsRepository {

        private final JdbcTemplate jdbcTemplate ;

        public RecommendationsRepository(@Qualifier("recommendationsJdbcTemplate") JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }


    public  boolean userOf(UUID user, String type){
        var result = jdbcTemplate.queryForObject(

                "SELECT EXISTS(SELECT 1 FROM products p JOIN  transactions t " +
                        " ON p.id = t.product_id WHERE t.user_id = ?" +
                        " AND p.`TYPE` = ? LIMIT 1)",
                boolean.class,
                user,type);

        return result != null && result;
    }
    public  int sum(UUID id, String type, String string) {
        var result = jdbcTemplate.queryForObject(
                "SELECT SUM(amount)  FROM products p JOIN  transactions t  " +
                        "ON p.id = t.product_id WHERE t.user_id = ? " +
                        "AND p.`TYPE` = ? AND t.`TYPE` = ?",
                int.class,
                id,type,string);
        return result != null ? result : 0;

    }



    }

