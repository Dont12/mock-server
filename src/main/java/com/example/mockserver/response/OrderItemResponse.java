package com.example.mockserver.response;

public class OrderItemResponse {
    private Long productId;
    private Long roomId;
    private String productName;
    private String roomName;
    private String checkInDate;
    private String checkOutDate;
    private String checkInTime;
    private String checkOutTime;
    private int baseGuestCount;
    private int maxGuestCount;
    private double price;

    public OrderItemResponse() {}

    // Setters
    public void setProductId(Long productId) { this.productId = productId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setRoomName(String roomName) { this.roomName = roomName; }
    public void setCheckInDate(String checkInDate) { this.checkInDate = checkInDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }
    public void setBaseGuestCount(int baseGuestCount) { this.baseGuestCount = baseGuestCount; }
    public void setMaxGuestCount(int maxGuestCount) { this.maxGuestCount = maxGuestCount; }
    public void setPrice(double price) { this.price = price; }

    // Getters...

    public Long getProductId() {
        return productId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public String getProductName() {
        return productName;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public int getBaseGuestCount() {
        return baseGuestCount;
    }

    public int getMaxGuestCount() {
        return maxGuestCount;
    }

    public double getPrice() {
        return price;
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
}
