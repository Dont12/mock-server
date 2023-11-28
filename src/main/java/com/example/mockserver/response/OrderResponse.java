package com.example.mockserver.response;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {
    private List<OrderItemResponse> orderItems;

    public OrderResponse() {
        this.orderItems = new ArrayList<>();
    }

    public List<OrderItemResponse> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemResponse> orderItems) {
        this.orderItems = orderItems;
    }
}
