package com.example.mockserver.controller.response;

import com.example.mockserver.response.OrderHistoryItemResponse;
import java.util.List;

public record OrderHistoryRealResponse(
    Long size,
    Long pageNumber,
    Long totalPages,
    Long totalElements,
    List<OrderHistoryItemResponse> orderHistories
) {

}
