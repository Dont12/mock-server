package com.example.mockserver.response;

public record RegisterOrderItem(
    Long productId,
    Long roomId,
    String productName,
    String imageUrl,
    String roomName,
    int baseGuestCount,
    int maxGuestCount,
    int guestCount,
    int price,
    String checkInTime,
    String checkInDate,
    String checkOutTime,
    String checkOutDate
) {
}
