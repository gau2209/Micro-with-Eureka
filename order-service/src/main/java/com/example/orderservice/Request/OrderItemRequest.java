package com.example.orderservice.Request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private Long id;
    private String code;
    private BigDecimal price;
    private Integer quantity;


}

