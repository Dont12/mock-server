package com.example.mockserver.response;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailResponse {
    private Long orderId;
    private String name;
    private String phone;
    private String userName;
    private String userPhone;
    private List<OrderDetailItemResponse> orderItems;

    public OrderDetailResponse() {
        this.orderItems = new ArrayList<>();
    }

    // Setters
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }
    public void setOrderItems(List<OrderDetailItemResponse> orderItems) { this.orderItems = orderItems; }

    // Getters...

    public Long getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public List<OrderDetailItemResponse> getOrderItems() {
        return orderItems;
    }
}
