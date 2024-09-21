package com.example.orderservice.Service;

import com.example.orderservice.Entity.Order;
import com.example.orderservice.Entity.orderItem;
import com.example.orderservice.Repository.IOrderRepository;
import com.example.orderservice.Request.OrderItemRequest;
import com.example.orderservice.Request.OrderRequest;
import com.example.orderservice.client.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService{
    private final IOrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) throws IllegalAccessException {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<orderItem> orderItems = orderRequest.getItems().stream()
                .map(this::maptoDTO).toList();
        order.setOrderItemId(orderItems);

        List<String> codes = order.getOrderItemId().stream().map(orderItem::getCode).toList();
        List<Integer> quan = order.getOrderItemId().stream().map(orderItem::getQuantity).toList();


        boolean b = this.inventoryClient.isInStock(codes,quan);

        if(b){
            this.orderRepository.save(order);
        }
        else{
            throw new IllegalAccessException("Product " + orderRequest.getItems()+" is not in stock, pls try again");
        }


    }

    @Override
    public Optional<Order> getOrderbyID(Long id) {
        return Optional.of(this.orderRepository.findById(id).get());
    }



    private orderItem maptoDTO(OrderItemRequest orderItemRequest) {
        orderItem orderItem = new orderItem();
        orderItem.setPrice(orderItemRequest.getPrice());
        orderItem.setQuantity(orderItemRequest.getQuantity());
        orderItem.setCode(orderItemRequest.getCode());
        return orderItem;

    }

}
