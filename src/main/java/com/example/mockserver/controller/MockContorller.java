package com.example.mockserver.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockContorller {

    @PostMapping("/users")
    public String 회원가입() {
        return "{\n"
            + "\t\"email\": \"a@a.com\",\n"
            + "\t\"password\": \"password\",\n"
            + "\t\"nickname\": \"nickname\",\n"
            + "\t\"phone\": \"010-0000-0000\"\n"
            + "}";
    }

    @GetMapping("/users")
    public String 나의정보확인() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "\t\"data\": {\n"
            + "\t\t\"email\":\"a@a.com\",\n"
            + "\t\t\"nickname\": \"nickname\",\n"
            + "\t\t\"phone\": \"010-0000-0000\"\n"
            + "\t}\n"
            + "}";
    }

    @PostMapping("/auth/login")
    public String 로그인() {
        return "{\n"
            + "  \"status\": \"SUCCESS\",\n"
            + "  \"data\": {\n"
            + "    \"grantType\": \"Bearer\",\n"
            + "    \"accessToken\": \"accessToken\",\n"
            + "    \"refreshToken\": \"refreshToken\"\n"
            + "  }\n"
            + "}";
    }

    @PostMapping("/auth/logout")
    public String 로그아웃() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "}";
    }

    @GetMapping("/products")
    public String 숙박업소목록() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\",\n"
            + "\t\"data\": [\n"
            + "\t\t{\n"
            + "\t\t\t\"id\": 1,\n"
            + "\t\t\t\"name\": \"숙박업소\",\n"
            + "\t\t\t\"imageUrl\": \"이미지URL\",\n"
            + "\t\t\t\"minPrice\": 0\n"
            + "\t\t},\n"
            + "\t\t{\n"
            + "\t\t\t\"id\": 2,\n"
            + "\t\t\t\"name\": \"숙박업소\",\n"
            + "\t\t\t\"imageUrl\": \"이미지URL\",\n"
            + "\t\t\t\"minPrice\": 0\n"
            + "\t\t},\n"
            + "\t]\n"
            + "}";
    }

    @GetMapping("/products/{id}")
    public String 숙박업소상세조회(Long id) {
        return "{\n"
            + "\t\"status\": \"SUCCESS\",\n"
            + "\t\"data\": {\n"
            + "\t\t\"id\": 1,\n"
            + "\t\t\"name\": \"숙박업소\",\n"
            + "\t\t\"zipCode\": \"우편번호\",\n"
            + "\t\t\"address\": \"주소\",\n"
            + "\t\t\"description\": \"설명\",\n"
            + "\t\t\"longitude\": 123.123,\n"
            + "\t\t\"latitude\": 123.123,\n"
            + "\t\t\"imageUrl\": \"이미지URL\",\n"
            + "\t\t\"rooms\": [\n"
            + "\t\t\t{\n"
            + "\t\t\t\t\"id\": 1,\n"
            + "\t\t\t\t\"name\": \"이름\",\n"
            + "\t\t\t\t\"basicGuestCount\": 2,\n"
            + "\t\t\t\t\"maxGuestCount\": 4,\n"
            + "\t\t\t\t\"price\": 100000,\n"
            + "\t\t\t\t\"checkInTime\": \"13:00\",\n"
            + "\t\t\t\t\"checkOutTime\": \"11:00\",\n"
            + "\t\t\t\t\"imageUrl\": \"이미지URL\",\n"
            + "\t\t\t\t\"reserveDate\": \"2010-01-01\",\n"
            + "\t\t\t\t\"stock\": 2,\n"
            + "\t\t\t\t// 숙소 제공 시설\n"
            + "\t\t\t\t\"roomBathFacility\": \"Y\",\n"
            + "        \"roomBath\": \"Y\",\n"
            + "        \"roomHomeTheater\": \"\",\n"
            + "        \"roomAircondition\": \"Y\",\n"
            + "        \"roomTv\": \"Y\",\n"
            + "        \"roomPc\": \"\",\n"
            + "        \"roomCable\": \"Y\",\n"
            + "        \"roomInternet\": \"Y\",\n"
            + "        \"roomRefrigerator\": \"Y\",\n"
            + "        \"roomToiletries\": \"Y\",\n"
            + "        \"roomSofa\": \"Y\",\n"
            + "        \"roomCook\": \"\",\n"
            + "        \"roomTable\": \"Y\",\n"
            + "        \"roomHairdryer\": \"Y\"\n"
            + "\t\t\t}\n"
            + "\t\t]\n"
            + "\t}\n"
            + "}";
    }

    @GetMapping("/carts")
    public String 장바구니목록조회() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "\t\"data\": {\n"
            + "\t\t\"totalPrice\": 100000,\n"
            + "\t\t\"items\": [\n"
            + "\t\t\t{\n"
            + "\t\t\t\t\"id\": 1,\n"
            + "\t\t\t\t\"product\": {\n"
            + "\t\t\t\t\t\"productId\": 1,\n"
            + "\t\t\t\t\t\"roomId\": 1,\n"
            + "\t\t\t\t\t\"productName\": \"숙박업소 이름\",\n"
            + "\t\t\t\t\t\"imageUrl\": \"숙박업소 이미지URL\",\n"
            + "\t\t\t\t\t\"address\": \"숙박업소 주소\",\n"
            + "\t\t\t\t\t\"roomName\": \"방 이름\"\n"
            + "\t\t\t\t\t\"baseGuestCount\": 2,\n"
            + "\t\t\t\t\t\"maxGuestCount\": 4,\n"
            + "\t\t\t\t\t\"price\": 100000,\n"
            + "\t\t\t\t\t\"checkInTime\": \"13:00\",\n"
            + "\t\t\t\t\t\"checkOutTime\": \"11:00\",\n"
            + "\t\t\t\t\t\"stock\": 1\n"
            + "\t\t\t\t}\n"
            + "\t\t\t\t\"checkInDate\": \"2023-11-25\",\n"
            + "\t\t\t\t\"checkOutDate\": \"2023-11-27\",\n"
            + "\t\t\t\t\"numberOfNights\": 2\n"
            + "\t\t\t}\n"
            + "\t\t]\n"
            + "\t}\n"
            + "}";
    }

    @PostMapping("/carts")
    public String 장바구니에담기() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "}";
    }

    @DeleteMapping("/carts")
    public String 장바구니삭제() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "}";
    }

    @GetMapping("/carts/order")
    public String 장바구니예약신청() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "\t\"data\": {\n"
            + "\t\t\"totalPrice\": 100000,\n"
            + "\t\t\"orderItem\": [\n"
            + "\t\t\t{\n"
            + "\t\t\t\t\"productId\": 1,\n"
            + "\t\t\t\t\"roomId\": 1,\n"
            + "\t\t\t\t\"productName\": \"숙박업소 이름\",\n"
            + "\t\t\t\t\"roomName\": \"방 이름\",\n"
            + "\t\t\t\t\"checkInDate\": \"2010-01-01\",\n"
            + "\t\t\t\t\"checkInTime\": \"13:00\",\n"
            + "\t\t\t\t\"checkOutDate\": \"2010-01-02\",\n"
            + "\t\t\t\t\"checkOutTime\": \"11:00\",\n"
            + "\t\t\t\t\"baseGuestCount\": 2,\n"
            + "\t\t\t\t\"maxGuestCount\": 4,\n"
            + "\t\t\t\t\"price\": 100000\n"
            + "\t\t\t}\n"
            + "\t\t]\n"
            + "\t}\n"
            + "}";
    }

    @GetMapping("/orders/history")
    public String 주문내역조회() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "\t\"data\": [\n"
            + "\t\t{\n"
            + "\t\t\t\"orderId\": 1,\n"
            + "\t\t\t\"createDate\": \"2010-01-01\",\n"
            + "\t\t\t\"orderItem\": {  \n"
            + "\t\t\t\t\"orderItemId\": 1,\n"
            + "\t\t\t\t\"productId\": 1,\n"
            + "\t\t\t\t\"roomId\": 1,\n"
            + "\t\t\t\t\"productName\": \"숙박업소 이름\",\n"
            + "\t\t\t\t\"imageUrl\": \"숙박업소 이미지URL\",\n"
            + "\t\t\t\t\"roomName\": \"방 이름\"\n"
            + "\t\t\t\t\"baseGuestCount\": 2,\n"
            + "\t\t\t\t\"maxGuestCount\": 4,\n"
            + "\t\t\t\t\"checkInDate\": \"2010-01-01\",\n"
            + "\t\t\t\t\"checkInTime\": \"13:00\",\n"
            + "\t\t\t\t\"checkOutDate\": \"2010-01-02\",\n"
            + "\t\t\t\t\"checkOutTime\": \"11:00\"\n"
            + "\t\t\t}\n"
            + "\t]\n"
            + "}";
    }

    @GetMapping("/orders/history/{id}")
    public String 주문내역상세조회(Long id) {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "\t\"data\": {\n"
            + "\t\t\"orderId\": 1,\n"
            + "\t\t\"name\": \"예약 이름\",\n"
            + "\t\t\"phone\": \"010-0000-0000\",\n"
            + "\t\t\"userName\": \"이용자 이름\",\n"
            + "\t\t\"userPhone\": \"010-0000-0000\",\n"
            + "\t\t\"orderItems\": [\n"
            + "\t\t\t{\n"
            + "\t\t\t\t\"orderItemId\": 1,\n"
            + "\t\t\t\t\"productId\": 1,\n"
            + "\t\t\t\t\"roomId\": 1,\n"
            + "\t\t\t\t\"productName\": \"숙박업소 이름\",\n"
            + "\t\t\t\t\"imageUrl\": \"숙박업소 이미지URL\",\n"
            + "\t\t\t\t\"roomName\": \"방 이름\"\n"
            + "\t\t\t\t\"baseGuestCount\": 2,\n"
            + "\t\t\t\t\"maxGuestCount\": 4,\n"
            + "\t\t\t\t\"checkInTime\": \"13:00\",\n"
            + "\t\t\t\t\"checkOutTime\": \"11:00\"\n"
            + "\t\t]\n"
            + "\t}\n"
            + "}";
    }

    @GetMapping("/orders/{id}")
    public String 예약신청조회() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "\t\"data\": {\n"
            + "\t\t\"orderId\": 1,\n"
            + "\t\t\"totalPrice\": 100000,\n"
            + "\t\t\"imageUrl\": \"숙박업소 이미지URL\",\n"
            + "\t\t\"name\": \"예약자 이름\",\n"
            + "\t\t\"phone\": \"010-0000-0000\",\n"
            + "\t\t\"orderItems\": [\n"
            + "\t\t\t{\n"
            + "\t\t\t\t\"orderItemId\": \"예약 번호\",\n"
            + "\t\t\t\t\"productId\": 1,\n"
            + "\t\t\t\t\"roomId\": 1,\n"
            + "\t\t\t\t\"productName\": \"숙박업소 이름\",\n"
            + "\t\t\t\t\"imageUrl\": \"숙박업소 이미지URL\",\n"
            + "\t\t\t\t\"roomName\": \"방 이름\",\n"
            + "\t\t\t\t\"baseGuestCount\": 2,\n"
            + "\t\t\t\t\"maxGuestCount\": 4,\n"
            + "\t\t\t\t\"guestCount\": 4,\n"
            + "\t\t\t\t\"price\": 10000,\n"
            + "\t\t\t\t\"checkInTime\": \"13:00\",\n"
            + "\t\t\t\t\"checkInDate\": \"2010-01-01\",\n"
            + "\t\t\t\t\"checkOutTime\": \"11:00\",\n"
            + "\t\t\t\t\"checkOutDate\": \"2010-01-02\"\n"
            + "\t\t\t}\n"
            + "\t\t]\n"
            + "\t}\n"
            + "}";
    }

    @PostMapping
    public String 예약신청() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "\t\"data\": {\n"
            + "\t\t\"orderId\": 1\n"
            + "\t}\n"
            + "}";
    }

    @PostMapping("/orders/payment")
    public String 예약결제() {
        return "{\n"
            + "\t\"status\": \"SUCCESS\"\n"
            + "}";
    }
}
