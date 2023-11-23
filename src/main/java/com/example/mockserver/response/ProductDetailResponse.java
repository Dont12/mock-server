package com.example.mockserver.response;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailResponse {
    private Long id;
    private String name;
    private String zipCode;
    private String address;
    private String description;
    private double longitude;
    private double latitude;
    private String imageUrl;
    private List<RoomResponse> rooms;

    public ProductDetailResponse() {
        this.rooms = new ArrayList<>();
    }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setAddress(String address) { this.address = address; }
    public void setDescription(String description) { this.description = description; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setRooms(List<RoomResponse> rooms) { this.rooms = rooms; }
}
