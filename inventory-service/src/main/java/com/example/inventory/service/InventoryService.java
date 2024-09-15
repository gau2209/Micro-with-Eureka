package com.example.inventory.service;

import com.example.inventory.DTO.InventoryResponse;
import com.example.inventory.DTO.OrderItemCoQu;
import com.example.inventory.Entity.Inventory;
import com.example.inventory.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService{
    private final InventoryRepository inventoryRepository;
    private final WebClient.Builder webClientBuilder;

//    @Transactional(readOnly = true)
//    public List<InventoryResponse> isInStock(List<String> codes){
//        List<Inventory> inventories = new ArrayList<>();
//        try {
//            for(String i : codes){
//                Inventory invent = this.inventoryRepository.findByCode(i).orElseThrow(() -> new RuntimeException( i + " doesnt exist"));
//                inventories.add(invent);
//        }
//        }catch (Exception ex){
//            throw new RuntimeException(ex.getMessage());
//      }
//        return inventories.stream().map(inventory -> InventoryResponse.builder()
//                .code(inventory.getCode())
//                .isInStock(inventory.getQuantity()>0).build()).toList();
//
//    }

@Transactional
@Override
    public List<InventoryResponse> isInStock(@RequestParam List<String> codes, @RequestParam List<Integer> quan){
        List<Inventory> inventories = new ArrayList<>();
        try {
            for(int i =0 ;i<codes.size();i++){
                Inventory invent = this.inventoryRepository.findByCode(codes.get(i)).orElseThrow(() -> new RuntimeException( codes + " doesnt exist"));

                if(invent.getQuantity() < quan.get(i)){
                    throw new Exception("Not enough quantity for " + codes.get(i));
                }

                invent.setQuantity(invent.getQuantity() - quan.get(i));
                inventories.add(invent);
        }
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
      }
        return inventories.stream().map(inventory -> InventoryResponse.builder()
                .code(inventory.getCode())
                .isInStock(inventory.getQuantity()>0)
                .build()).toList();
    }
    @Override
    public List<InventoryResponse> getAllInventory() {
         List<Inventory> inventories= this.inventoryRepository.findAll();
         List<InventoryResponse> inventoryResponses = new ArrayList<>();
        for (Inventory i: inventories) {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.setCode(i.getCode());
            inventoryResponses.add(inventoryResponse);
        }
        return inventoryResponses;
    }


}
