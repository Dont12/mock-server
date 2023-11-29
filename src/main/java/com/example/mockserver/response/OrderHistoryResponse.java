package com.example.mockserver.response;

import java.util.List;

public class OrderHistoryResponse {
    private Long orderId;
    private String reserveDate;
    private List<OrderHistoryItemResponse> orderItems;

    public OrderHistoryResponse() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public List<OrderHistoryItemResponse> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(
        List<OrderHistoryItemResponse> orderItems) {
        this.orderItems = orderItems;
    }
}
