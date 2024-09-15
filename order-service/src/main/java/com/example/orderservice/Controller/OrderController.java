package com.example.orderservice.Controller;

import com.example.orderservice.Entity.Order;
import com.example.orderservice.Request.OrderItemRequest;
import com.example.orderservice.Request.OrderRequest;
import com.example.orderservice.Service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService OderService;

//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public String placeOrder(@RequestBody OrderRequest orderRequest) throws IllegalAccessException {
//        try {
//            this.OderService.placeOrder(orderRequest);
//            return "You have been bought successfully";
//        }
//        catch (Exception ex)
//        {
//            return "Some products doesn't exist, please try again";
//        }
//    }

//        @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public String placeOrder(@RequestBody List<OrderItemRequest> orderItemRequests) throws IllegalAccessException {
//        try {
//            this.OderService.placeOrder(orderItemRequests);
//            return "You have been bought successfully";
//        }
//        catch (Exception ex)
//        {
//            return "Some products doesn't exist, please try again";
//        }
//    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) throws IllegalAccessException {
        try {
            this.OderService.placeOrder(orderRequest);
            return "You have been bought successfully";
        }
        catch (Exception ex)
        {
            return "Some products doesn't exist, please try again";
        }
    }

    @GetMapping("/{OrderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long OrderId) {
        Order order = this.OderService.getOrderbyID(OrderId).get();
        return ResponseEntity.ok(order);
    }
}
