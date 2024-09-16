package com.example.productservice.Controller;

import com.example.productservice.Exception.ProductExistException;
import com.example.productservice.Request.ProductRequest;
import com.example.productservice.Response.ProductResponse;
import com.example.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest product){
            productService.createProduct(product);
    }

    @GetMapping()

    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        List<ProductResponse> p =  productService.getAllProduct();
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        try {
            ProductResponse p = this.productService.getProdById(id);
            return ResponseEntity.ok(p);
        }
        catch (ProductExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
