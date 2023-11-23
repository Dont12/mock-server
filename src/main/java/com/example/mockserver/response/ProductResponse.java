package com.example.mockserver.response;

public class ProductResponse {
    private Long id;
    private String name;
    private String imageUrl;
    private int minPrice;

    public ProductResponse() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getMinPrice() {
        return minPrice;
    }
}
