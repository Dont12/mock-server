package com.example.mockserver.response;

import java.util.List;

public record ReservationDetailResponse(
    String orderToken,
    int totalPrice,
    String name,
    String phone,
    List<RegisterOrderItem> registerOrderItems
) {
}
