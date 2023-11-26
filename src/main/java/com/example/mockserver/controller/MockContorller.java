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
        productDetail.setId(id);
        productDetail.setName("숙박업소");
        productDetail.setZipCode("우편번호");
        productDetail.setAddress("주소");
        productDetail.setDescription("설명");
        productDetail.setLongitude(123.123);
        productDetail.setLatitude(123.123);
        productDetail.setImageUrl("이미지URL");

        List<RoomResponse> rooms = new ArrayList<>();
        RoomResponse room = getRoomResponse();

        rooms.add(room);
        productDetail.setRooms(rooms);

        return ResponseBody.ok(productDetail);
    }

    private static RoomResponse getRoomResponse() {
        RoomResponse room = new RoomResponse();
        room.setId(1L);
        room.setName("이름");
        room.setBasicGuestCount(2);
        room.setMaxGuestCount(4);
        room.setPrice(100000);
        room.setCheckInTime("13:00");
        room.setCheckOutTime("11:00");
        room.setImageUrl("이미지URL");
        room.setReserveDate("2010-01-01");
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
        CartItemResponse item = new CartItemResponse();
        item.setId(1L);

        CartProductResponse product = new CartProductResponse();
        product.setProductId(1L);
        product.setRoomId(1L);
        product.setProductName("숙박업소 이름");
        product.setImageUrl("숙박업소 이미지URL");
        product.setAddress("숙박업소 주소");
        product.setRoomName("방 이름");
        product.setBaseGuestCount(2);
        product.setMaxGuestCount(4);
        product.setPrice(100000);
        product.setCheckInTime("13:00");
        product.setCheckOutTime("11:00");
        product.setStock(1);

        item.setProduct(product);
        item.setCheckInDate("2023-11-25");
        item.setCheckOutDate("2023-11-27");
        item.setNumberOfNights(2);

        items.add(item);
        cart.setItems(items);

        return ResponseBody.ok(cart);
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
        OrderItemResponse orderItem = new OrderItemResponse();
        orderItem.setProductId(1L);
        orderItem.setRoomId(1L);
        orderItem.setProductName("숙박업소 이름");
        orderItem.setRoomName("방 이름");
        orderItem.setCheckInDate("2010-01-01");
        orderItem.setCheckInTime("13:00");
        orderItem.setCheckOutDate("2010-01-02");
        orderItem.setCheckOutTime("11:00");
        orderItem.setBaseGuestCount(2);
        orderItem.setMaxGuestCount(4);
        orderItem.setPrice(100000);

        orderItems.add(orderItem);
        orderResponse.setOrderItems(orderItems);

        return ResponseBody.ok(orderResponse);
    }


    @GetMapping("/orders/history")
    public ResponseBody<List<OrderHistoryResponse>> 주문내역조회() {
        List<OrderHistoryResponse> orderHistories = new ArrayList<>();

        OrderHistoryResponse orderHistory = new OrderHistoryResponse();
        orderHistory.setOrderId(1L);
        orderHistory.setCreatedDate("2010-01-01");

        OrderHistoryItemResponse orderItem = new OrderHistoryItemResponse();
        orderItem.setOrderItemId(1L);
        orderItem.setProductId(1L);
        orderItem.setRoomId(1L);
        orderItem.setProductName("숙박업소 이름");
        orderItem.setImageUrl("숙박업소 이미지URL");
        orderItem.setRoomName("방 이름");
        orderItem.setBaseGuestCount(2);
        orderItem.setMaxGuestCount(4);
        orderItem.setCheckInDate("2010-01-01");
        orderItem.setCheckInTime("13:00");
        orderItem.setCheckOutDate("2010-01-02");
        orderItem.setCheckOutTime("11:00");

        orderHistory.setOrderItem(orderItem);
        orderHistories.add(orderHistory);

        return ResponseBody.ok(orderHistories);
    }


    @GetMapping("/orders/history/{id}")
    public ResponseBody<OrderDetailResponse> 주문내역상세조회(@PathVariable Long id) {
        OrderDetailResponse orderDetail = new OrderDetailResponse();
        orderDetail.setOrderId(id);
        orderDetail.setName("예약 이름");
        orderDetail.setPhone("010-0000-0000");
        orderDetail.setUserName("이용자 이름");
        orderDetail.setUserPhone("010-0000-0000");

        List<OrderDetailItemResponse> orderItems = new ArrayList<>();
        OrderDetailItemResponse orderItem = new OrderDetailItemResponse();
        orderItem.setOrderItemId(1L);
        orderItem.setProductId(1L);
        orderItem.setRoomId(1L);
        orderItem.setProductName("숙박업소 이름");
        orderItem.setImageUrl("숙박업소 이미지URL");
        orderItem.setRoomName("방 이름");
        orderItem.setBaseGuestCount(2);
        orderItem.setMaxGuestCount(4);
        orderItem.setCheckInTime("13:00");
        orderItem.setCheckOutTime("11:00");

        orderItems.add(orderItem);
        orderDetail.setOrderItems(orderItems);

        return ResponseBody.ok(orderDetail);
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
        ReservationItemResponse reservationItem = new ReservationItemResponse();
        reservationItem.setOrderItemId(1L);
        reservationItem.setProductId(1L);
        reservationItem.setRoomId(1L);
        reservationItem.setProductName("숙박업소 이름");
        reservationItem.setImageUrl("숙박업소 이미지URL");
        reservationItem.setRoomName("방 이름");
        reservationItem.setBaseGuestCount(2);
        reservationItem.setMaxGuestCount(4);
        reservationItem.setGuestCount(4);
        reservationItem.setPrice(10000);
        reservationItem.setCheckInTime("13:00");
        reservationItem.setCheckInDate("2010-01-01");
        reservationItem.setCheckOutTime("11:00");
        reservationItem.setCheckOutDate("2010-01-02");

        orderItems.add(reservationItem);
        reservationResponse.setOrderItems(orderItems);

        return ResponseBody.ok(reservationResponse);
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
}
