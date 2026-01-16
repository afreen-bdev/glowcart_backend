package com.glowcart.api.dto;

import java.util.List;

public class PlaceOrderRequest {

    public AddressDTO address;
    public List<CartItemDTO> items;
    public int totalAmount;

    public static class AddressDTO {
        public String fullName;
        public String mobile;
        public String line1;
        public String line2;
        public String city;
        public String state;
        public String pincode;
    }

    public static class CartItemDTO {
        public Long productId;
        public String name;
        public String brand;
        public int price;
        public int qty;
        public String imageUrl;
    }
}