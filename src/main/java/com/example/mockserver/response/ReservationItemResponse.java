package com.example.mockserver.response;

public class ReservationItemResponse {
    private Long orderItemId;
    private Long productId;
    private Long roomId;
    private String productName;
    private String imageUrl;
    private String roomName;
    private int baseGuestCount;
    private int maxGuestCount;
    private int guestCount;
    private double price;
    private String checkInTime;
    private String checkInDate;
    private String checkOutTime;
    private String checkOutDate;

    public ReservationItemResponse() {}

    // Setters
    public void setOrderItemId(Long orderItemId) { this.orderItemId = orderItemId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setRoomName(String roomName) { this.roomName = roomName; }
    public void setBaseGuestCount(int baseGuestCount) { this.baseGuestCount = baseGuestCount; }
    public void setMaxGuestCount(int maxGuestCount) { this.maxGuestCount = maxGuestCount; }
    public void setGuestCount(int guestCount) { this.guestCount = guestCount; }
    public void setPrice(double price) { this.price = price; }
    public void setCheckInTime(String checkInTime) { this.checkInTime = checkInTime; }
    public void setCheckInDate(String checkInDate) { this.checkInDate = checkInDate; }
    public void setCheckOutTime(String checkOutTime) { this.checkOutTime = checkOutTime; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }

    // Getters...

    public Long getOrderItemId() {
        return orderItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public String getProductName() {
        return productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getBaseGuestCount() {
        return baseGuestCount;
    }

    public int getMaxGuestCount() {
        return maxGuestCount;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public double getPrice() {
        return price;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }
}
