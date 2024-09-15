package com.example.productservice.Service;

import com.example.productservice.Exception.ProductExistException;
import com.example.productservice.Request.ProductRequest;
import com.example.productservice.Response.ProductResponse;

import java.util.List;

public interface IProductService {
    void createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProduct();

    ProductResponse getProdById(String id) throws ProductExistException;
}
