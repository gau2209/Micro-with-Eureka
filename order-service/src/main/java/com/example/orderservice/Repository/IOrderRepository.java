package com.example.orderservice.Repository;

import com.example.orderservice.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {
}
