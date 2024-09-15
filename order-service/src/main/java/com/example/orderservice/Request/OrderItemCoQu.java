package com.example.orderservice.Request;

import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemCoQu {
    private String code;
    private Integer quantity;
}
