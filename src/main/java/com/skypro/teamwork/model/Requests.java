package com.skypro.teamwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity

public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String query;
    private List<String> arguments;
    private Boolean negate;

    public Requests(Long id,String query, List<String> arguments, Boolean negate) {
        this.id = id;
        this.arguments = arguments;
        this.query = query;
        this.negate = negate;
    }

    public Requests() {
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
}
