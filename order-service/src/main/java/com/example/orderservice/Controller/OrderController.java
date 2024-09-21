package com.example.orderservice.Controller;

import com.example.orderservice.Entity.Order;
import com.example.orderservice.Request.OrderRequest;
import com.example.orderservice.Service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    private final IOrderService OderService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
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
