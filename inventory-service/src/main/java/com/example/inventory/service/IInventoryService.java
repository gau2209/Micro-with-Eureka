package com.example.inventory.service;

import com.example.inventory.DTO.InventoryResponse;
import com.example.inventory.DTO.OrderItemCoQu;

import java.util.List;

public interface IInventoryService {
//  List<InventoryResponse> isInStock(List<String> code);
List<InventoryResponse> isInStock( List<String> codes,List<Integer> quan);

    List<InventoryResponse> getAllInventory();
}
