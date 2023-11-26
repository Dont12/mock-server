package com.example.mockserver.response;

import java.util.List;

public class OrderHistoryResponse {
    private Long orderId;
    private String createdDate;
    private List<OrderHistoryItemResponse> orderItems;

    public OrderHistoryResponse() {}

    // Setters
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public void setOrderItems(List<OrderHistoryItemResponse> orderItems) { this.orderItems = orderItems; }

    // Getters...

    public Long getOrderId() {
        return orderId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public List<OrderHistoryItemResponse> getOrderItems() {
        return this.orderItems;
    }
}
