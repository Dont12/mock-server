package com.example.mockserver.response;

public class OrderHistoryResponse {
    private Long orderId;
    private String createdDate;
    private OrderHistoryItemResponse orderItem;

    public OrderHistoryResponse() {}

    // Setters
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public void setOrderItem(OrderHistoryItemResponse orderItem) { this.orderItem = orderItem; }

    // Getters...

    public Long getOrderId() {
        return orderId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public OrderHistoryItemResponse getOrderItem() {
        return orderItem;
    }
}
