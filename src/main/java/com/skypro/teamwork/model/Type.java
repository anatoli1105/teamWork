package com.skypro.teamwork.model;

import org.springframework.stereotype.Component;
@Component

public enum Type {
    DEBIT("DEBIT"),
    INVEST("INVEST"),
    CREDIT("CREDIT"),
    SAVING("SAVING"),
    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW");
private String type;

    Type(String type) {
        this.type=type;

    }
    public String getType(){
        return type;
    }
    @Override
    public String toString() {
        return type;
    }

    }
