package com.example.mockserver.controller;

import com.example.mockserver.response.CartItemResponse;
import com.example.mockserver.response.CartProductResponse;
import com.example.mockserver.response.CartResponse;
import com.example.mockserver.response.LoginResponse;
import com.example.mockserver.response.OrderDetailItemResponse;
import com.example.mockserver.response.OrderDetailResponse;
import com.example.mockserver.response.OrderHistoryItemResponse;
import com.example.mockserver.response.OrderHistoryResponse;
import com.example.mockserver.response.OrderItemResponse;
import com.example.mockserver.response.OrderResponse;
import com.example.mockserver.response.PageResponse;
import com.example.mockserver.response.PaymentResponse;
import com.example.mockserver.response.ProductDetailResponse;
import com.example.mockserver.response.ProductResponse;
import com.example.mockserver.response.RegisterOrderItem;
import com.example.mockserver.response.ReservationDetailResponse;
import com.example.mockserver.response.ReservationItemResponse;
import com.example.mockserver.response.ReservationRequestResponse;
import com.example.mockserver.response.ReservationResponse;
import com.example.mockserver.response.ResponseBody;
import com.example.mockserver.response.RoomResponse;
import com.example.mockserver.response.UserResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockContorller {

    @PostMapping("/auth/logout")
    public ResponseBody<Void> 로그아웃() {
        return ResponseBody.ok();
    }

    @GetMapping("/products")
    public ResponseBody<List<ProductResponse>> 숙박업소목록() {
        List<ProductResponse> productList = new ArrayList<>();

        // 예시 데이터 추가
        productList.add(getProductResponse(2804347L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg", 170000));
        productList.add(getProductResponse(2706613L, "송계헌 [한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg", 450000));
        productList.add(getProductResponse(1972030L, "상유재 [한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg", 70000));
        productList.add(getProductResponse(1836470L, "베이브리즈가족호텔", "http://tong.visitkorea.or.kr/cms/resource/06/1836506_image2_1.JPG", 120000));
        productList.add(getProductResponse(2531417L, "전주 한옥숙박체험관[한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/90/2531490_image2_1.jpg", 60000));

        return ResponseBody.ok(productList);
    }

    private static ProductResponse getProductResponse(long id, String name, String imageUrl, Integer minPrice) {
        ProductResponse product = new ProductResponse();
        product.setId(id);
        product.setName(name);
        product.setImageUrl(imageUrl);
        product.setMinPrice(minPrice);
        return product;
    }

    @GetMapping("/products/{id}")
    public ResponseBody<ProductDetailResponse> 숙박업소상세조회(@PathVariable Long id) {
        ProductDetailResponse productDetail = new ProductDetailResponse();
        productDetail.setId(2804347L);
        productDetail.setName("스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]");
        productDetail.setZipCode("32152");
        productDetail.setAddress("주소");
        productDetail.setDescription("설명");
        productDetail.setLongitude(126.2741703813);
        productDetail.setLatitude(36.6766143894);
        productDetail.setImageUrl("http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg");

        List<RoomResponse> rooms = new ArrayList<>();
        rooms.add(getRoomResponse(55641L, "A/3", 4, 4, 170000, "http://tong.visitkorea.or.kr/cms/resource/02/2803402_image2_1.jpg", "15:00", "11:00", "2010-01-01"));
        rooms.add(getRoomResponse(55642L, "B/5", 4, 6, 200000, "http://tong.visitkorea.or.kr/cms/resource/02/2803402_image2_1.jpg", "15:00", "11:00", "2010-01-01"));
        productDetail.setRooms(rooms);

        return ResponseBody.ok(productDetail);
    }

    private static RoomResponse getRoomResponse(Long id, String name, int basicGuestCount, int maxGuestCount, int price, String imageUrl, String checkInTime, String checkOutTime, String reserveDate) {
        RoomResponse room = new RoomResponse();
        room.setId(id);
        room.setName(name);
        room.setBasicGuestCount(basicGuestCount);
        room.setMaxGuestCount(maxGuestCount);
        room.setPrice(price);
        room.setCheckInTime(checkInTime);
        room.setCheckOutTime(checkOutTime);
        room.setImageUrl(imageUrl);
        room.setReserveDate(reserveDate);
        room.setStock(2);
        room.setRoomBathFacility("Y");
        room.setRoomBath("Y");
        room.setRoomHomeTheater("");
        room.setRoomAircondition("Y");
        room.setRoomTv("Y");
        room.setRoomPc("");
        room.setRoomCable("Y");
        room.setRoomInternet("Y");
        room.setRoomRefrigerator("Y");
        room.setRoomToiletries("Y");
        room.setRoomSofa("Y");
        room.setRoomCook("");
        room.setRoomTable("Y");
        room.setRoomHairdryer("Y");
        return room;
    }

    @GetMapping("/carts")
    public ResponseBody<CartResponse> 장바구니목록조회() {
        CartResponse cart = new CartResponse();
        cart.setTotalPrice(100000);

        PageResponse pageResponse = new PageResponse();
        pageResponse.setMaxPage(1L);
        pageResponse.setSize(1L);
        pageResponse.setTotalCount(1L);
        cart.setPage(pageResponse);

        List<CartItemResponse> items = new ArrayList<>();
        items.add(getCartItemResponse(1L, 2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg", "충청남도 태안군 몽대로 448", "A/3", 4, 4, 170000, "15:00", "11:00", "2023-11-25", "2023-11-27", 4));
        items.add(getCartItemResponse(2L, 2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg", "충청남도 태안군 몽대로 448", "A/3", 4, 4, 170000, "15:00", "11:00", "2023-11-25", "2023-11-27", 4));
        items.add(getCartItemResponse(3L, 1972030L, 42637L, "상유재 [한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg", "강원특별자치도 정선군 정선읍 봉양3길 22-8", "대청방", 4, 6, 130000, "14:00", "10:00", "2023-12-25", "2023-12-27", 4));
        items.add(getCartItemResponse(4L, 1972030L, 42638L, "상유재 [한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg", "강원특별자치도 정선군 정선읍 봉양3길 22-8", "사랑방", 4, 5, 100000, "14:00", "10:00", "2023-12-25", "2023-12-27", 4));
        items.add(getCartItemResponse(5L, 2804347L, 55641L, "송계헌 [한국관광 품질인증/Korea Quality]", "http://tong.visitkorea.or.kr/cms/resource/42/2706142_image2_1.jpg", "경상북도 안동시 풍천면 병산길 332", "송계헌", 4, 5, 450000, "16:00", "10:00", "2024-01-25", "2024-01-27", 4));
        items.add(getCartItemResponse(6L, 1836470L, 38759L, "베이브리즈가족호텔", "http://tong.visitkorea.or.kr/cms/resource/42/2706142_image2_1.jpg", "경상북도 안동시 풍천면 병산길 332", "A", 2, 2, 100000, "15:00", "11:00", "2024-01-25", "2024-01-27", 2));
        cart.setItems(items);

        return ResponseBody.ok(cart);
    }

    private static CartItemResponse getCartItemResponse(
        Long itemId, Long productId, Long roomId, String productName, String imageUrl,
        String address, String roomName, int baseGuestCount, int maxGuestCount,
        int price, String checkInTime, String checkOutTime, String checkInDate, String checkOutDate,
        int guestCount
    ) {
        CartItemResponse item = new CartItemResponse();
        item.setId(itemId);

        CartProductResponse product = new CartProductResponse();
        product.setProductId(productId);
        product.setRoomId(roomId);
        product.setProductName(productName);
        product.setImageUrl(imageUrl);
        product.setAddress(address);
        product.setRoomName(roomName);
        product.setBaseGuestCount(baseGuestCount);
        product.setMaxGuestCount(maxGuestCount);
        product.setPrice(price);
        product.setCheckInTime(checkInTime);
        product.setCheckOutTime(checkOutTime);
        product.setStock(2);
        product.setGuestCount(guestCount);

        item.setProduct(product);
        item.setCheckInDate(checkInDate);
        item.setCheckOutDate(checkOutDate);
        item.setNumberOfNights(2);
        return item;
    }

    @PostMapping("/carts")
    public ResponseBody<Void> 장바구니에담기() {
        return ResponseBody.ok();
    }

    @DeleteMapping("/carts")
    public ResponseBody<Void> 장바구니삭제() {
        return ResponseBody.ok();
    }

    @GetMapping("/carts/order")
    public ResponseBody<OrderResponse> 장바구니예약신청() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setTotalPrice(100000);

        List<OrderItemResponse> orderItems = new ArrayList<>();
        orderItems.add(getOrderItemResponse(
            2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]",
            "A/3", "2023-11-25", "15:00", "2023-11-27",
            "11:00", 4, 4, 170000
        ));
        orderItems.add(getOrderItemResponse(
            2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]",
            "A/3", "2023-11-25", "15:00", "2023-11-27",
            "11:00", 4, 4, 170000
        ));
        orderItems.add(getOrderItemResponse(
            1972030L, 42637L, "상유재 [한국관광 품질인증/Korea Quality]",
            "대청방", "2023-12-25", "14:00", "2023-12-27",
            "10:00", 4, 4, 130000
        ));
        orderItems.add(getOrderItemResponse(
            1972030L, 42637L, "상유재 [한국관광 품질인증/Korea Quality]",
            "사랑방", "2023-12-25", "14:00", "2023-12-27",
            "10:00", 4, 5, 100000
        ));
        orderItems.add(getOrderItemResponse(
            2706613L, 42638L, "송계헌 [한국관광 품질인증/Korea Quality]",
            "송계헌", "2024-01-25", "16:00", "2023-01-27",
            "11:00", 4, 5, 450000
        ));
        orderItems.add(getOrderItemResponse(
            1836470L, 38759L, "베이브리즈가족호텔",
            "A", "2024-01-25", "16:00", "2023-01-27",
            "11:00", 2, 2, 100000
        ));
        orderResponse.setOrderItems(orderItems);

        return ResponseBody.ok(orderResponse);
    }

    private static OrderItemResponse getOrderItemResponse(
        Long productId, Long roomId, String productName, String roomName,
        String checkInDate, String checkInTime, String checkOutDate, String checkOutTime,
        int baseGuestCount, int maxGuestCount, int price
    ) {
        OrderItemResponse orderItem = new OrderItemResponse();
        orderItem.setProductId(productId);
        orderItem.setRoomId(roomId);
        orderItem.setProductName(productName);
        orderItem.setRoomName(roomName);
        orderItem.setCheckInDate(checkInDate);
        orderItem.setCheckInTime(checkInTime);
        orderItem.setCheckOutDate(checkOutDate);
        orderItem.setCheckOutTime(checkOutTime);
        orderItem.setBaseGuestCount(baseGuestCount);
        orderItem.setMaxGuestCount(maxGuestCount);
        orderItem.setPrice(price);
        return orderItem;
    }

    @GetMapping("/orders/history")
    public ResponseBody<List<OrderHistoryResponse>> 주문내역조회() {
        List<OrderHistoryItemResponse> orderHistories = new ArrayList<>();

        OrderHistoryResponse orderHistory = new OrderHistoryResponse();
        orderHistory.setOrderId(1L);
        orderHistory.setCreatedDate("2010-01-01");

        orderHistories.add(getOrderHistoryItemResponse(
            1L, 2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]",
            "A/3", "2023-11-25", "15:00", "2023-11-27",
            "11:00", 4, 4, "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg"
        ));
        orderHistories.add(getOrderHistoryItemResponse(
            2L, 2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]",
            "A/3", "2023-11-25", "15:00", "2023-11-27",
            "11:00", 4, 4, "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg"
        ));
        orderHistories.add(getOrderHistoryItemResponse(
            3L, 1972030L, 42637L, "상유재 [한국관광 품질인증/Korea Quality]",
            "대청방", "2023-12-25", "14:00", "2023-12-27",
            "10:00", 4, 4, "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg"
        ));
        orderHistories.add(getOrderHistoryItemResponse(
            4L, 1972030L, 42637L, "상유재 [한국관광 품질인증/Korea Quality]",
            "사랑방", "2023-12-25", "14:00", "2023-12-27",
            "10:00", 4, 5, "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg"
        ));
        orderHistories.add(getOrderHistoryItemResponse(
            5L, 2706613L, 42638L, "송계헌 [한국관광 품질인증/Korea Quality]",
            "송계헌", "2024-01-25", "16:00", "2023-01-27",
            "11:00", 4, 5, "http://tong.visitkorea.or.kr/cms/resource/42/2706142_image2_1.jpg"
        ));
        orderHistories.add(getOrderHistoryItemResponse(
            6L, 1836470L, 38759L, "베이브리즈가족호텔",
            "A", "2024-01-25", "16:00", "2023-01-27",
            "11:00", 2, 2, "http://tong.visitkorea.or.kr/cms/resource/42/2706142_image2_1.jpg"
        ));
        orderHistory.setOrderItems(orderHistories);

        OrderHistoryResponse orderHistory2 = new OrderHistoryResponse();
        orderHistory2.setOrderId(2L);
        orderHistory2.setCreatedDate("2010-01-02");

        List<OrderHistoryItemResponse> orderHistories2 = new ArrayList<>();
        orderHistories2.add(getOrderHistoryItemResponse(
            7L, 2706613L, 42638L, "송계헌 [한국관광 품질인증/Korea Quality]",
            "송계헌", "2024-02-25", "16:00", "2023-02-27",
            "11:00", 4, 5, "http://tong.visitkorea.or.kr/cms/resource/42/2706142_image2_1.jpg"
        ));
        orderHistory2.setOrderItems(orderHistories2);

        return ResponseBody.ok(List.of(orderHistory, orderHistory2));
    }

    private static OrderHistoryItemResponse getOrderHistoryItemResponse(
        Long orderItemId, Long productId, Long roomId, String productName, String roomName,
        String checkInDate, String checkInTime, String checkOutDate, String checkOutTime,
        int baseGuestCount, int maxGuestCount, String imageUrl
    ) {
        OrderHistoryItemResponse orderItem = new OrderHistoryItemResponse();
        orderItem.setOrderItemId(orderItemId);
        orderItem.setProductId(productId);
        orderItem.setRoomId(roomId);
        orderItem.setProductName(productName);
        orderItem.setRoomName(roomName);
        orderItem.setCheckInDate(checkInDate);
        orderItem.setCheckInTime(checkInTime);
        orderItem.setCheckOutDate(checkOutDate);
        orderItem.setCheckOutTime(checkOutTime);
        orderItem.setBaseGuestCount(baseGuestCount);
        orderItem.setMaxGuestCount(maxGuestCount);
        orderItem.setImageUrl(imageUrl);
        return orderItem;
    }

    @GetMapping("/orders/history/{id}")
    public ResponseBody<OrderDetailResponse> 주문내역상세조회(@PathVariable Long id) {
        OrderDetailResponse orderDetail = new OrderDetailResponse();
        orderDetail.setOrderId(id);
        orderDetail.setName("김패캠");
        orderDetail.setPhone("010-0000-0000");
        orderDetail.setUserName("김패캠");
        orderDetail.setUserPhone("010-0000-0000");
        orderDetail.setTotalPrice(139000);
        orderDetail.setReserveDate("2023-11-11");
        orderDetail.setPayment("CARD");

        List<OrderDetailItemResponse> orderItems = new ArrayList<>();

        orderItems.add(getOrderDetailItemResponse(1L));
        orderItems.add(getOrderDetailItemResponse(2L));
        orderItems.add(getOrderDetailItemResponse(3L));
        orderDetail.setOrderItems(orderItems);

        return ResponseBody.ok(orderDetail);
    }

    private static OrderDetailItemResponse getOrderDetailItemResponse(Long id) {
        OrderDetailItemResponse orderItem = new OrderDetailItemResponse();
        orderItem.setOrderItemId(id);
        orderItem.setProductId(2804347L);
        orderItem.setRoomId(55641L);
        orderItem.setProductName("스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]");
        orderItem.setImageUrl("http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg");
        orderItem.setRoomName("A/3");
        orderItem.setBaseGuestCount(4);
        orderItem.setMaxGuestCount(4);
        orderItem.setCheckInDate("2024-01-25");
        orderItem.setCheckInTime("15:00");
        orderItem.setCheckOutDate("2024-01-27");
        orderItem.setCheckOutTime("11:00");
        return orderItem;
    }

    @GetMapping("/orders/{id}")
    public ResponseBody<ReservationResponse> 예약신청조회(@PathVariable Long id) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setOrderId(id);
        reservationResponse.setTotalPrice(100000);
        reservationResponse.setImageUrl("숙박업소 이미지URL");
        reservationResponse.setName("예약자 이름");
        reservationResponse.setPhone("010-0000-0000");

        List<ReservationItemResponse> orderItems = new ArrayList<>();
        orderItems.add(
            getReservationItemResponse(
                1L, 2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]",
                "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg", "A/3", 4, 4,
                "15:00", "11:00"
            )
        );
        orderItems.add(
            getReservationItemResponse(
                2L, 2804347L, 55641L, "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]",
                "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg", "A/3", 4, 4,
                "15:00", "11:00"
            )
        );
        orderItems.add(
            getReservationItemResponse(
                3L, 1972030L, 42637L, "상유재 [한국관광 품질인증/Korea Quality]",
                "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg", "대청", 4, 6,
                "14:00", "10:00"
            )
        );
        orderItems.add(
            getReservationItemResponse(
                4L, 1972030L, 42638L, "상유재 [한국관광 품질인증/Korea Quality]",
                "http://tong.visitkorea.or.kr/cms/resource/22/2629122_image2_1.jpg", "대청", 4, 5,
                "14:00", "10:00"
            )
        );
        orderItems.add(
            getReservationItemResponse(
                5L, 2706613L, 42638L, "송계헌 [한국관광 품질인증/Korea Quality]",
                "http://tong.visitkorea.or.kr/cms/resource/42/2706142_image2_1.jpg", "송계헌", 4, 5,
                "16:00", "11:00"
            )
        );
        orderItems.add(
            getReservationItemResponse(
                6L, 1836470L, 38759L, "베이브리즈가족호텔",
                "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg", "A", 2, 2,
                "15:00", "11:00"
            )
        );
        reservationResponse.setOrderItems(orderItems);

        return ResponseBody.ok(reservationResponse);
    }

    private static ReservationItemResponse getReservationItemResponse(
        Long orderItemId, Long productId, Long roomId, String productName, String imageUrl, String roomName,
        int baseGuestCount, int maxGuestCount, String checkInTime, String checkOutTime
    ) {
        ReservationItemResponse orderItem = new ReservationItemResponse();
        orderItem.setOrderItemId(orderItemId);
        orderItem.setProductId(productId);
        orderItem.setRoomId(roomId);
        orderItem.setProductName(productName);
        orderItem.setImageUrl(imageUrl);
        orderItem.setRoomName(roomName);
        orderItem.setBaseGuestCount(baseGuestCount);
        orderItem.setMaxGuestCount(maxGuestCount);
        orderItem.setCheckInTime(checkInTime);
        orderItem.setCheckOutTime(checkOutTime);
        return orderItem;
    }

    @PostMapping("/orders")
    public ResponseBody<ReservationRequestResponse> 예약신청() {
        ReservationRequestResponse reservationRequestResponse = new ReservationRequestResponse();
        reservationRequestResponse.setOrderToken("SDGF44SDF123TBDH");

        return ResponseBody.ok(reservationRequestResponse);
    }

    @PostMapping("/orders/payment")
    public ResponseBody<PaymentResponse> 예약결제() {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setOrderId(1L);
        return ResponseBody.ok(paymentResponse);
    }

    @GetMapping("/orders")
    public ResponseBody<ReservationDetailResponse> 예약신청조회(
        @RequestParam String orderToken
    ) {
        RegisterOrderItem item = new RegisterOrderItem(
            2804347L, 55641L,
            "스테이 앤드 스튜디오 여여재[한국관광 품질인증/Korea Quality]",
            "http://tong.visitkorea.or.kr/cms/resource/41/2803441_image2_1.jpg",
            "A/3", 4, 4, 4,
            99000, "15:00", "2023-11-24", "11:00", "2023-11-25"
        );

        ReservationDetailResponse response = new ReservationDetailResponse(
            "af7b554f-b733-47fd-ae65-8fd5454de27f",
            100000,
            "김패캠",
            "010-0000-0000",
            List.of(item, item)
        );

        return ResponseBody.ok(response);
    }
}
