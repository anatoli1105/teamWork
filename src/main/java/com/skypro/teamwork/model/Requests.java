package com.skypro.teamwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String query;
    private String arguments;
    private Boolean negate;

    public Requests(Long id, String arguments, Boolean negate, String query) {
        this.id = id;
        this.arguments = arguments;
        this.query = query;
        this.negate = negate;
    }

    public Requests() {
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
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
