package com.skypro.teamwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;
@Entity
public class Recommendations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productName;
    private UUID productId;
    private String productText;
    private List<Requests> requestsList;

    public Recommendations(UUID productId, String productName, String productText,List<Requests> requestsList) {
        this.productId = productId;
        this.productName = productName;
        this.productText = productText;
        this.requestsList=requestsList;

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

    public List<Requests> getRequestsList() {
        return requestsList;
    }

    public void setRequestsList(List<Requests> requestsList) {
        this.requestsList = requestsList;
    }
}
