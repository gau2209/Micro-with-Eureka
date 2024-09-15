package com.example.productservice.Service;

import com.example.productservice.Entity.Product;
import com.example.productservice.Exception.ProductExistException;
import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.Request.ProductRequest;
import com.example.productservice.Response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product p = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(p);
        log.info("ProductId = "+ p.getId() + " is saved");
        log.info("Product {} is saved", p.getId());
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> p = productRepository.findAll();
        return p.stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public ProductResponse getProdById(String id) throws ProductExistException {
        Product p = this.productRepository.findById(id).orElseThrow(() -> new ProductExistException("Product is not exist"));
        return ProductResponse.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice()).build();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .id(product.getId()).build();
    }

}
