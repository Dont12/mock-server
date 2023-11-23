package com.example.mockserver.response;

public class CartItemResponse {
    private Long id;
    private CartProductResponse product;
    private String checkInDate;
    private String checkOutDate;
    private int numberOfNights;

    public CartItemResponse() {}

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setProduct(CartProductResponse product) { this.product = product; }
    public void setCheckInDate(String checkInDate) { this.checkInDate = checkInDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }
    public void setNumberOfNights(int numberOfNights) { this.numberOfNights = numberOfNights; }

    // Getters...

    public Long getId() {
        return id;
    }

    public CartProductResponse getProduct() {
        return product;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }
}
