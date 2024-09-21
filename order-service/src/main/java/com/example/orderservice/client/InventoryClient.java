package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

//@FeignClient(value = "inventory",url = "http://localhost:8083")
public interface InventoryClient {
//    @RequestMapping(method = RequestMethod.GET,value = "/api/inventory")
    @GetExchange("/api/inventory")
    Boolean isInStock(@RequestParam List<String> codes,@RequestParam List<Integer> quan);
}
