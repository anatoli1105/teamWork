package com.skypro.teamwork.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public class RecommendationsRepository {

        private final JdbcTemplate jdbcTemplate;

        public RecommendationsRepository(@Qualifier("recommendationsJdbcTemplate") JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public UUID getRandomTransactionAmount(UUID user){
            var result = jdbcTemplate.queryForObject(

                    "SELECT t.user_id FROM products p JOIN  transactions t " +
                            " ON p.id = t.product_id WHERE t.user_id = ?" +
                            " AND p.`TYPE` ='DEBIT' AND p.`TYPE` !='INVEST' LIMIT 1",
                    UUID.class,
                    user);

            return result != null ? result : null;
        }


        public int getSumAmountSaving(UUID id){
        var result = jdbcTemplate.queryForObject(
                "SELECT SUM(amount)  FROM products p JOIN  transactions t  " +
                        "ON p.id = t.product_id WHERE t.user_id = ? " +
                        "AND p.`TYPE` ='SAVING' AND t.`TYPE` ='DEPOSIT'",
                int.class,
                id);
        return result != null ? result :0;
    }
    public int getSumAmountDebit(UUID id){
        var result = jdbcTemplate.queryForObject(
                "SELECT SUM(amount)  FROM products p JOIN  transactions t  " +
                        "ON p.id = t.product_id WHERE t.user_id = ? " +
                        "AND p.`TYPE` ='DEBIT' AND t.`TYPE` ='DEPOSIT'",
                int.class,
                id);
        return result != null ? result :0;
    }
    public UUID getDebit(UUID user){
        var result = jdbcTemplate.queryForObject(

                "SELECT t.user_id FROM products p JOIN  transactions t " +
                        " ON p.id = t.product_id WHERE t.user_id = ?" +
                        " AND p.`TYPE` ='DEBIT' LIMIT 1",
                UUID.class,
                user);

        return result != null ? result : null;
    }
    public int getSumAmountWithdraw(UUID id) {
        var result = jdbcTemplate.queryForObject(
                "SELECT SUM(amount)  FROM products p JOIN  transactions t  " +
                        "ON p.id = t.product_id WHERE t.user_id = ? " +
                        "AND p.`TYPE` ='DEBIT' AND t.`TYPE` ='WITHDRAW'",
                int.class,
                id);
        return result != null ? result : 0;

    }
    public UUID getNotCredit(UUID user){
        var result = jdbcTemplate.queryForObject(

                "SELECT t.user_id FROM products p JOIN  transactions t " +
                        " ON p.id = t.product_id WHERE t.user_id = ?" +
                        " AND p.`TYPE` !='CREDIT' LIMIT 1",
                UUID.class,
                user);

        return result != null ? result : null;
    }



    }

