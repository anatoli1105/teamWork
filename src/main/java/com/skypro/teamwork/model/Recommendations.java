package com.skypro.teamwork.model;

import java.util.UUID;

public class Recommendations {
    private String productName;
    private UUID productId;
    private String productText;

    public Recommendations(UUID productId, String productName, String productText) {
        this.productId = productId;
        this.productName = productName;
        this.productText = productText;
    }

    public UUID getProductId() {

        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }
}
