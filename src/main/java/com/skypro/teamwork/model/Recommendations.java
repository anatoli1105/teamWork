package com.skypro.teamwork.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Recommendations {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID useId;
    private String productName;
    private UUID productId;
    private String productText;
    @OneToMany(mappedBy = "recommendations")
    private List<Request>requests;

    public Recommendations(UUID useId, String productName, UUID productId, String productText,
                           List<Request>requests) {
        this.useId = useId;
        this.productName = productName;
        this.productId=productId;
        this.productText = productText;

        this.requests=requests;

    }

    public Recommendations() {
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



    public UUID getUseId() {
        return useId;
    }

    public void setUseId(UUID useId) {
        this.useId = useId;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
