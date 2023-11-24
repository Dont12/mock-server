package com.example.mockserver.response;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    private int totalPrice;
    private PageResponse page;
    private List<CartItemResponse> items;

    public CartResponse() {
        this.items = new ArrayList<>();
    }

    // Setters
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
    public void setItems(List<CartItemResponse> items) { this.items = items; }

    // Getters...

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<CartItemResponse> getItems() {
        return items;
    }

    public PageResponse getPage() {
        return page;
    }

    public void setPage(PageResponse page) {
        this.page = page;
    }
}
