package com.example.mockserver.response;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {
    private double totalPrice;
    private List<OrderItemResponse> orderItems;

    public OrderResponse() {
        this.orderItems = new ArrayList<>();
    }

    // Setters
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setOrderItems(List<OrderItemResponse> orderItems) { this.orderItems = orderItems; }

    // Getters...

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<OrderItemResponse> getOrderItems() {
        return orderItems;
    }
}
