package com.example.mockserver.response;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    private double totalPrice;
    private List<CartItemResponse> items;

    public CartResponse() {
        this.items = new ArrayList<>();
    }

    // Setters
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setItems(List<CartItemResponse> items) { this.items = items; }

    // Getters...

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<CartItemResponse> getItems() {
        return items;
    }
}
