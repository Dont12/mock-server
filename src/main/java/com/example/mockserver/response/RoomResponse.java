package com.example.mockserver.response;

public class RoomResponse {
    private Long id;
    private String name;
    private int basicGuestCount;
    private int maxGuestCount;
    private double price;
    private String checkInTime;
    private String checkOutTime;
    private String imageUrl;
    private String reserveDate;
    private int stock;
    // 숙소 제공 시설
    private String roomBathFacility;
    private String roomBath;
    private String roomHomeTheater;
    private String roomAircondition;
    private String roomTv;
    private String roomPc;
    private String roomCable;
    private String roomInternet;
    private String roomRefrigerator;
    private String roomToiletries;
    private String roomSofa;
    private String roomCook;
    private String roomTable;
    private String roomHairdryer;

    // 기본 생성자
    public RoomResponse() {}

    // Setters and Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasicGuestCount() {
        return basicGuestCount;
    }

    public void setBasicGuestCount(int basicGuestCount) {
        this.basicGuestCount = basicGuestCount;
    }

    public int getMaxGuestCount() {
        return maxGuestCount;
    }

    public void setMaxGuestCount(int maxGuestCount) {
        this.maxGuestCount = maxGuestCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getRoomBathFacility() {
        return roomBathFacility;
    }

    public void setRoomBathFacility(String roomBathFacility) {
        this.roomBathFacility = roomBathFacility;
    }

    public String getRoomBath() {
        return roomBath;
    }

    public void setRoomBath(String roomBath) {
        this.roomBath = roomBath;
    }

    public String getRoomHomeTheater() {
        return roomHomeTheater;
    }

    public void setRoomHomeTheater(String roomHomeTheater) {
        this.roomHomeTheater = roomHomeTheater;
    }

    public String getRoomAircondition() {
        return roomAircondition;
    }

    public void setRoomAircondition(String roomAircondition) {
        this.roomAircondition = roomAircondition;
    }

    public String getRoomTv() {
        return roomTv;
    }

    public void setRoomTv(String roomTv) {
        this.roomTv = roomTv;
    }

    public String getRoomPc() {
        return roomPc;
    }

    public void setRoomPc(String roomPc) {
        this.roomPc = roomPc;
    }

    public String getRoomCable() {
        return roomCable;
    }

    public void setRoomCable(String roomCable) {
        this.roomCable = roomCable;
    }

    public String getRoomInternet() {
        return roomInternet;
    }

    public void setRoomInternet(String roomInternet) {
        this.roomInternet = roomInternet;
    }

    public String getRoomRefrigerator() {
        return roomRefrigerator;
    }

    public void setRoomRefrigerator(String roomRefrigerator) {
        this.roomRefrigerator = roomRefrigerator;
    }

    public String getRoomToiletries() {
        return roomToiletries;
    }

    public void setRoomToiletries(String roomToiletries) {
        this.roomToiletries = roomToiletries;
    }

    public String getRoomSofa() {
        return roomSofa;
    }

    public void setRoomSofa(String roomSofa) {
        this.roomSofa = roomSofa;
    }

    public String getRoomCook() {
        return roomCook;
    }

    public void setRoomCook(String roomCook) {
        this.roomCook = roomCook;
    }

    public String getRoomTable() {
        return roomTable;
    }

    public void setRoomTable(String roomTable) {
        this.roomTable = roomTable;
    }

    public String getRoomHairdryer() {
        return roomHairdryer;
    }

    public void setRoomHairdryer(String roomHairdryer) {
        this.roomHairdryer = roomHairdryer;
    }

    // 각 필드에 대한 setter와 getter 메소드 추가...
}
