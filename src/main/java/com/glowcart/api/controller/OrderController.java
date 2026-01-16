package com.glowcart.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.glowcart.api.dto.PlaceOrderRequest;
import com.glowcart.api.entity.Address;
import com.glowcart.api.entity.Order;
import com.glowcart.api.entity.OrderItem;
import com.glowcart.api.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PostMapping("/place")
    public Order placeOrder(@RequestBody PlaceOrderRequest req) {

        // Address
        Address address = new Address();
        address.setFullName(req.address.fullName);
        address.setMobile(req.address.mobile);
        address.setLine1(req.address.line1);
        address.setLine2(req.address.line2);
        address.setCity(req.address.city);
        address.setState(req.address.state);
        address.setPincode(req.address.pincode);

        // Order
        Order order = new Order();
        order.setTotalAmount(req.totalAmount);
        order.setAddress(address);

        // Items
        List<OrderItem> items = new ArrayList<>();
        for (PlaceOrderRequest.CartItemDTO ci : req.items) {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProductId(ci.productId);
            item.setName(ci.name);
            item.setBrand(ci.brand);
            item.setPrice(ci.price);
            item.setQty(ci.qty);
            item.setImageUrl(ci.imageUrl);
            items.add(item);
        }

        order.setItems(items);

        return orderRepo.save(order);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
}