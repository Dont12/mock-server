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

    private int totalPrice;

    private String reserveDate;

    private String payment;

    public OrderDetailResponse() {
        this.orderItems = new ArrayList<>();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<OrderDetailItemResponse> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(
        List<OrderDetailItemResponse> orderItems) {
        this.orderItems = orderItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
