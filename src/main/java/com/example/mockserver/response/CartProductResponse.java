package com.example.mockserver.response;

public class CartProductResponse {
    private Long productId;
    private Long roomId;
    private String productName;
    private String imageUrl;
    private String address;
    private String roomName;
    private int baseGuestCount;
    private int maxGuestCount;
    private int price;
    private String checkInTime;
    private String checkOutTime;
    private int stock;

    public CartProductResponse() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getBaseGuestCount() {
        return baseGuestCount;
    }

    public void setBaseGuestCount(int baseGuestCount) {
        this.baseGuestCount = baseGuestCount;
    }

    public int getMaxGuestCount() {
        return maxGuestCount;
    }

    public void setMaxGuestCount(int maxGuestCount) {
        this.maxGuestCount = maxGuestCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
