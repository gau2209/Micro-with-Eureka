package com.example.inventory.controller;

import com.example.inventory.DTO.InventoryResponse;
import com.example.inventory.DTO.OrderItemCoQu;
import com.example.inventory.service.IInventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@CrossOrigin
public class InventoryController {
    private final IInventoryService InventoryService;

//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<?> isInStock(@RequestParam List<String> codes){
//         try{
//             List<InventoryResponse> t = this.InventoryService.isInStock(codes);
//             return  ResponseEntity.ok(t);
//         }
//         catch (Exception ex){
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("có sản phẩm không tồn tại, vui lòng thử lại");
//         }
//
//    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> isInStock(@RequestParam List<String> codes,@RequestParam List<Integer> quan) throws JsonProcessingException {
         try{
             List<InventoryResponse> t = this.InventoryService.isInStock(codes,quan);
             return  ResponseEntity.ok(t);
         }
         catch (Exception ex){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("có sản phẩm không tồn tại, vui lòng thử lại");
         }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<InventoryResponse>> getAllInventory(){
        List<InventoryResponse> InventoryResponse = this.InventoryService.getAllInventory();
        return ResponseEntity.ok(InventoryResponse);
    }
}
