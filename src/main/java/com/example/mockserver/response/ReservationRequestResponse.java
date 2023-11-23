package com.example.mockserver.response;

public class ReservationRequestResponse {
    private Long orderId;

    public ReservationRequestResponse() {}

    // Setters
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    // Getters...

    public Long getOrderId() {
        return orderId;
    }
}

