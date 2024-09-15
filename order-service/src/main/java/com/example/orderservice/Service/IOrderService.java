package com.example.orderservice.Service;

import com.example.orderservice.Entity.Order;
import com.example.orderservice.Request.OrderItemRequest;
import com.example.orderservice.Request.OrderRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
//    void placeOrder(List<OrderItemRequest> orderRequest) throws IllegalAccessException, JsonProcessingException;

    void placeOrder(OrderRequest orderRequest) throws IllegalAccessException;
    Optional<Order> getOrderbyID(Long id);

}
