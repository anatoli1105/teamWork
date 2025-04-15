package com.skypro.teamwork.model;

import java.util.UUID;

public class Recommendations {
    private String product_name;
    private UUID product_id;
    private String product_text;

    public Recommendations(UUID product_id, String product_name, String product_text) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_text = product_text;
    }

    public UUID getProduct_id() {

        return product_id;
    }

    public void setProduct_id(UUID product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_text() {
        return product_text;
    }

    public void setProduct_text(String product_text) {
        this.product_text = product_text;
    }
}
