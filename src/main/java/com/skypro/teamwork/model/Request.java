package com.skypro.teamwork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String query;
    private List<String> arguments;
    private Boolean negate;

    @ManyToOne
    @JoinColumn(name = "recommendations_product_name")
    @JsonIgnore
    private Recommendations recommendations;


    public Request(String query, List<String> arguments, Boolean negate, Recommendations recommendations) {

        this.arguments = arguments;
        this.query = query;
        this.negate = negate;
        this.recommendations = recommendations;
    }

    public Request() {
    }


    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public Boolean getNegate() {
        return negate;
    }

    public void setNegate(Boolean negate) {
        this.negate = negate;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recommendations getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(Recommendations recommendations) {
        this.recommendations = recommendations;
    }
}
