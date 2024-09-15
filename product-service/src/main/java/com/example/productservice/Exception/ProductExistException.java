package com.example.productservice.Exception;

public class ProductExistException extends Exception {
    public ProductExistException(String productIsNotExist) {
        super(productIsNotExist);
    }
}
