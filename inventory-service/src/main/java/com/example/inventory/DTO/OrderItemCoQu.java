package com.example.inventory.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemCoQu {
    private String code;
    private Integer quantity;
}
