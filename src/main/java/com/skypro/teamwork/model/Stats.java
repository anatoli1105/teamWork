package com.skypro.teamwork.model;

import java.util.UUID;

public class Stats {
    private UUID ruleId;
    private int count;

    public Stats(UUID ruleId, int count) {
        this.ruleId = ruleId;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UUID getRuleId() {
        return ruleId;
    }

    public void setRuleId(UUID ruleId) {
        this.ruleId = ruleId;
    }
}

