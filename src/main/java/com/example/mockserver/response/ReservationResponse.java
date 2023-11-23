package com.example.mockserver.response;

import java.util.ArrayList;
import java.util.List;

public class ReservationResponse {
    private Long orderId;
    private double totalPrice;
    private String imageUrl;
    private String name;
    private String phone;
    private List<ReservationItemResponse> orderItems;

    public ReservationResponse() {
        this.orderItems = new ArrayList<>();
    }

    // Setters
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setOrderItems(List<ReservationItemResponse> orderItems) { this.orderItems = orderItems; }

    // Getters...

    public Long getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<ReservationItemResponse> getOrderItems() {
        return orderItems;
    }
}
