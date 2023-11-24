package com.example.mockserver.response;

public class ReservationRequestResponse {
    private String orderToken;

    public ReservationRequestResponse() {}

    // Setters
    public void setOrderToken(String orderToken) { this.orderToken = orderToken; }

    // Getters...

    public String getOrderToken() {
        return orderToken;
    }

}

